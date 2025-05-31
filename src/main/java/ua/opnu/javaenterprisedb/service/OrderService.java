package ua.opnu.javaenterprisedb.service;

import ua.opnu.javaenterprisedb.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrderStatus(Long id, String status);
}
