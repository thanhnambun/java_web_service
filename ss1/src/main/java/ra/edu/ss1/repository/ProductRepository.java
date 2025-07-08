package ra.edu.ss1.repository;


import ra.edu.ss1.entity.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    void update(Product product);
}
