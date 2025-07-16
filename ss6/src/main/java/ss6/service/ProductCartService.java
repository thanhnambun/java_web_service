package ss6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ss6.entity.ProductCart;
import ss6.entity.User;
import ss6.reopo.ProductCartRepository;

import java.util.List;

@Service
public class ProductCartService {
    @Autowired
    private ProductCartRepository productCartRepository;
    public List<ProductCart> getCartItemsByUser(User user){
        return productCartRepository.getProductCartByUser(user);
    }
    public ProductCart addToCart(ProductCart productCart){
        productCart = productCartRepository.save(productCart);
        return productCart;
    }
    public ProductCart updateQuantity(Long id, Integer quantity) {
        ProductCart productCart = productCartRepository.findById(id).get();
        productCart.setQuantity(productCart.getQuantity() + quantity);
        return productCartRepository.save(productCart);
    }
    public void removeFromCart(Long id){
        productCartRepository.deleteById(id);
    }
}
