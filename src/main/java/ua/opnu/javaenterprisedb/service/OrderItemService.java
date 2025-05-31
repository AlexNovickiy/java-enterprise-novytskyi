package ua.opnu.javaenterprisedb.service;

import ua.opnu.javaenterprisedb.model.OrderItem;
import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
    OrderItem createOrderItem(OrderItem item);
}
