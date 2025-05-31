package ua.opnu.javaenterprisedb.service;

import ua.opnu.javaenterprisedb.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
}
