package ua.opnu.javaenterprisedb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnoreProperties("orderItems")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties("orderItems")
    private Product product;

    private int quantity;


}
