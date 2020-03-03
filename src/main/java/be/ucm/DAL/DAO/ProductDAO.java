package be.ucm.DAL.DAO;

import be.ucm.DAL.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// CrudRepository
// PagingAndSortingRepository
// JpaRepository
public interface ProductDAO extends JpaRepository<Product, Integer> {
    Optional<Product> findOneByName(String name);

    @Query("SELECT p FROM Product p WHERE p.category = :category AND p.orders.size > 0")
    List<Product> searchByCategoryOrderedAtLeastOnce(@Param("category") String category);
    List<Product> findByCategory(String category);

}
