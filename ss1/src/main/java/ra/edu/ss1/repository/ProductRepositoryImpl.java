package ra.edu.ss1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ra.edu.ss1.entity.Product;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public void save(Product product) {
        em.persist(product);
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        Product product = em.find(Product.class, id);
        if (product == null) {
            return null;
        }else {
            return product;
        }
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        String  jpql = "select p from Product p";
        return em.createQuery(jpql, Product.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        em.remove(em.find(Product.class, id));
    }

    @Override
    @Transactional
    public void update(Product product) {
        em.merge(product);
    }
}
