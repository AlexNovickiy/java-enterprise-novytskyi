package ua.opnu.javaenterprisedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.javaenterprisedb.model.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);
}
