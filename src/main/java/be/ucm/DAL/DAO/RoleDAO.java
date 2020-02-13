package be.ucm.DAL.DAO;

import be.ucm.DAL.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Integer> {
}
