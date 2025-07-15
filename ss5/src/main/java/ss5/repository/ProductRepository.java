package ss5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ss5.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
