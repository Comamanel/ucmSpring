package be.ucm.DAL.DAO;

import be.ucm.DAL.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {
}
