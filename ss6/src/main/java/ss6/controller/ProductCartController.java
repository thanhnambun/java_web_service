package ss6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ss6.entity.DataResponse;
import ss6.entity.ProductCart;
import ss6.entity.User;
import ss6.service.ProductCartService;
import ss6.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/productCart")
public class ProductCartController {

    @Autowired
    private ProductCartService productCartService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/productCarts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse<List<ProductCart>>> getProductCart(@RequestParam Long id) {
        User currentUser = userService.findById(id);
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new DataResponse<>(null, HttpStatus.NOT_FOUND));
        }
        List<ProductCart> carts = productCartService.getCartItemsByUser(currentUser);
        return ResponseEntity.ok().body(new DataResponse<>(carts, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<DataResponse<ProductCart>> addProductCart(@RequestBody ProductCart productCart) {
        ProductCart added = productCartService.addToCart(productCart);
        return new ResponseEntity<>(new DataResponse<>(added, HttpStatus.ACCEPTED), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<ProductCart>> updateProductCart(
            @PathVariable Long id,
            @RequestParam Integer quantity) {
        ProductCart updated = productCartService.updateQuantity(id, quantity);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new DataResponse<>(null, HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.ok().body(new DataResponse<>(updated, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCart(@PathVariable Long id) {
        productCartService.removeFromCart(id);
        return ResponseEntity.noContent().build();
    }
}
