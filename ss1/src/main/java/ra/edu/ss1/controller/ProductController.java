package ra.edu.ss1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.ss1.entity.Product;
import ra.edu.ss1.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("home")
    public String product(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product";
    }
    @GetMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "form";
    }
    @PostMapping("/add")
    public String addProduct(Product product,Model model) {
        productRepository.save(product);
        String message = "Product added successfully";
        model.addAttribute("message", message);
        return "redirect:/product/add";
    }
    @GetMapping("/update")
    public String updateProduct(Model model, @RequestParam("id") Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "form";
    }
    @PostMapping("/update/id")
    public String updateProduct(Product product,Model model) {
        productRepository.update(product);
        String message = "Product updated successfully";
        model.addAttribute("message", message);
        return "redirect:/product/home";
    }
    @GetMapping("/delete")
    public String deleteProduct(Model model, @RequestParam("id") Long id) {
        productRepository.deleteById(id);
        String message = "Product deleted successfully";
        model.addAttribute("message", message);
        return "redirect:/product/home";
    }
}
