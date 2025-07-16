package ss6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ss6.entity.ProductPagination;
import ss6.entity.Product;
import ss6.reopo.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductPagination getAllProducts(Pageable pageable, String searchName) {
        Page<Product> page;
        if (searchName != null && !searchName.isBlank()) {
            page = productRepository.findByNameContainingIgnoreCase(searchName, pageable);
        } else {
            page = productRepository.findAll(pageable);
        }

        return new ProductPagination(
                page.getContent(),
                page.getTotalPages(),
                page.getSize(),
                page.getNumber()
        );
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setStock(product.getStock());
            return productRepository.save(existing);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
