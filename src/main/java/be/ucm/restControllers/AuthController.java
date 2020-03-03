package be.ucm.restControllers;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import be.ucm.DAL.DAO.ClientDAO;
import be.ucm.DTO.AuthenticationRequest;
import be.ucm.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    ClientDAO clientDAO;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {
        try {
            
            String login = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, data.getPassword()));
            String token = jwtTokenProvider.createToken(login, this.clientDAO.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Username " + login + "not found")).getRoles().stream().map(r -> r.getAuthority()).collect(Collectors.toList()));
            Map<Object, Object> model = new HashMap<>();
            model.put("username", login);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}

