package be.ucm;

import be.ucm.DAL.DAO.ClientDAO;
import be.ucm.DAL.DAO.OrderDAO;
import be.ucm.DAL.DAO.ProductDAO;
import be.ucm.DAL.DAO.RoleDAO;
import be.ucm.DAL.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class BouffeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BouffeApplication.class, args);
    }

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private OrderDAO orderDAO;

    @EventListener(ApplicationReadyEvent.class)
    public void adds(){
        addRoles();
        addUsers();
        addOrders();
    }
    public void addRoles(){
        Role admin = new Role().setName("ROLE_ADMIN");
        Role member = new Role().setName("ROLE_MEMBER");
        Role other = new Role().setName("ROLE_OTHER");

        roleDAO.save(admin);
        roleDAO.save(member);
        roleDAO.save(other);
    }
    public void addOrders(){
        Order o = new Order();
        o.setDate(LocalDate.now());
        o.setState(State.IN_PROGRESS);
        o.setClient(clientDAO.findById(1).orElse(null));
        orderDAO.save(o);
    }
    public void addUsers(){
        Address address = new Address();
        address.setCity("MY CITY");
        address.setNumber("MY NUMBER");
        address.setStreet("MY STREET");
        address.setZipCode("MY ZIPCODE");
        Client c = new Client("Oger", "Guillaume", "toto2", passwordEncoder.encode("1234"), address);
        c.getRoles().add(roleDAO.findById(1).orElse(null));
        c.getRoles().add(roleDAO.findById(2).orElse(null));
        c.getRoles().add(roleDAO.findById(3).orElse(null));
        clientDAO.save(c);
    }


}
