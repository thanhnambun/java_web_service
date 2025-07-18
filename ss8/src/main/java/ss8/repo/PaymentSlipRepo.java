package ss8.repo;

import ss8.model.entity.PaymentSlip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSlipRepo extends JpaRepository<PaymentSlip, Long> {
}