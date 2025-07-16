package ss6.reopo;

import org.springframework.data.jpa.repository.JpaRepository;
import ss6.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCreatedAt(LocalDateTime start, LocalDateTime end);
}
