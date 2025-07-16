package ss6.reopo;

import org.springframework.data.jpa.repository.JpaRepository;
import ss6.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
