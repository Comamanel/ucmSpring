package be.ucm.DAL.DAO;

import be.ucm.DAL.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<Client, Integer> {
}
