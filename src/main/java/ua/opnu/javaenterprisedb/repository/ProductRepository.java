package ua.opnu.javaenterprisedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.javaenterprisedb.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
