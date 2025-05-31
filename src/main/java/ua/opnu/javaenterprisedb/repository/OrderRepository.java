package ua.opnu.javaenterprisedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.javaenterprisedb.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
