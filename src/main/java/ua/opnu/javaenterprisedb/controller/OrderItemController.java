package ua.opnu.javaenterprisedb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.javaenterprisedb.model.OrderItem;
import ua.opnu.javaenterprisedb.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {
    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/by-order/{orderId}")
    public List<OrderItem> getByOrder(@PathVariable Long orderId) {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }

    @PostMapping
    public ResponseEntity<OrderItem> create(@RequestBody OrderItem item) {
        OrderItem createdOrderItem = orderItemService.createOrderItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem); // повертає статус 201 Created
    }
}


