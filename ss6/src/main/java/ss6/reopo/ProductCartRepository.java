package ss6.reopo;

import org.springframework.data.repository.CrudRepository;
import ss6.entity.ProductCart;
import ss6.entity.User;

import java.util.List;

public interface ProductCartRepository extends CrudRepository<ProductCart,Long> {
    List<ProductCart> getProductCartByUser(User user);
}
