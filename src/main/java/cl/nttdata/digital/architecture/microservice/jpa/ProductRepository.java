package cl.nttdata.digital.architecture.microservice.jpa;

import cl.nttdata.digital.architecture.microservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Get All Products
     *
     * List<Product> findAll();
     */
    /**
     * Save an entity
     *
     * Product save(Product p);
     */
}
