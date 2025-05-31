package ua.opnu.javaenterprisedb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.javaenterprisedb.model.Order;
import ua.opnu.javaenterprisedb.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        try {
            Order createdOrder = orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestBody String status) {
        String cleanedStatus = status.trim().replaceAll("[\\r\\n]+", "");
        Order updatedOrder = orderService.updateOrderStatus(id, cleanedStatus);
        return updatedOrder != null ? ResponseEntity.ok(updatedOrder) : ResponseEntity.notFound().build();
    }
}
