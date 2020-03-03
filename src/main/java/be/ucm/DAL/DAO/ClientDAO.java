package be.ucm.DAL.DAO;

import be.ucm.DAL.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientDAO extends JpaRepository<Client, Integer> {

    Optional<Client> findByLogin(String login);


}
