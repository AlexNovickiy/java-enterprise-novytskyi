package ua.opnu.javaenterprisedb.service;

import org.springframework.stereotype.Service;
import ua.opnu.javaenterprisedb.model.Order;
import ua.opnu.javaenterprisedb.model.OrderItem;
import ua.opnu.javaenterprisedb.model.Product;
import ua.opnu.javaenterprisedb.repository.OrderItemRepository;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderService orderService;
    private final ProductService productService;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderService orderService, ProductService productService) {
        this.orderItemRepository = orderItemRepository;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    @Override
    public OrderItem createOrderItem(OrderItem item) {
        if (item.getOrder() != null && item.getProduct() != null) {
            Order order = orderService.getOrderById(item.getOrder().getId());
            Product product = productService.getProductById(item.getProduct().getId());

            if (order != null && product != null) {
                item.setOrder(order);  // Устанавливаем реальный заказ
                item.setProduct(product);  // Устанавливаем реальный продукт
                return orderItemRepository.save(item);  // Сохраняем новый элемент заказа
            } else {
                throw new IllegalArgumentException("Invalid order or product ID");
            }
        } else {
            throw new IllegalArgumentException("Order and Product must not be null");
        }
    }
}
