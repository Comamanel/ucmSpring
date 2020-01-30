package be.ucm.restControllers;

import be.ucm.DAL.DAO.ClientDAO;
import be.ucm.DAL.entities.Client;
import be.ucm.DAL.entities.Product;
import be.ucm.DTO.client.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientDAO clientDAO;

    public ClientController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @GetMapping("")
    public ResponseEntity<List<ClientDTO>> getAll(){
        List<Client> clients = clientDAO.findAll();
        System.out.println(clients);

        return ResponseEntity.ok(clients.stream().map(ClientDTO::new).collect(Collectors.toList()));
    }
}
