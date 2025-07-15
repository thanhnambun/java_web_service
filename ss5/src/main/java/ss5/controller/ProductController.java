package ss5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ss5.entity.DataResponse;
import ss5.entity.Product;
import ss5.entity.ProductList;
import ss5.service.ProductServiceImp;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImp productService;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse<List<Product>>> getAllProductsJson() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new DataResponse<>(products, HttpStatus.OK));
    }


    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ProductList> getAllProductsXml() {
        return ResponseEntity.ok(new ProductList(productService.getAllProducts()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<Product>> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(new DataResponse<>(productService.createProduct(product), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DataResponse<Product>> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(new DataResponse<>(productService.updateProduct(product), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
