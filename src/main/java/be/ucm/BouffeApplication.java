package be.ucm;

import be.ucm.DAL.DAO.ClientDAO;
import be.ucm.DAL.DAO.OrderDAO;
import be.ucm.DAL.DAO.ProductDAO;
import be.ucm.DAL.entities.Address;
import be.ucm.DAL.entities.Client;
import be.ucm.DAL.entities.Order;
import be.ucm.DAL.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;

@SpringBootApplication
public class BouffeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BouffeApplication.class, args);
    }

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private OrderDAO orderDAO;
    @EventListener(ApplicationReadyEvent.class)
    public void adds(){
        addUsers();
        addOrders();
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
        Client c = new Client("Oger", "Guillaume", "toto2", bytesToHex("1234".getBytes()), address);
        clientDAO.save(c);
    }

    private String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
