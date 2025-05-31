package ua.opnu.javaenterprisedb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.javaenterprisedb.model.Product;
import ua.opnu.javaenterprisedb.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct); // повертає статус 201 Created
    }
}
