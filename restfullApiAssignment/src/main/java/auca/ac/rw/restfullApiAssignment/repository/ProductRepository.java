package auca.ac.rw.restfullApiAssignment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    List<Product> findByCategory(String category);





    List<Product> findByPriceAndBrand(Double price, String brand);


    


    // List<Product> findByPriceBetween(Double firstPrice, Double secondPrice);

}
