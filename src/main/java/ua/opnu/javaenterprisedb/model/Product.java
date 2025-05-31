package ua.opnu.javaenterprisedb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private double price;
    private int stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("product")
    private List<OrderItem> orderItems;
}