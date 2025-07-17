package java.ra.ss7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.ra.ss7.entity.PaymentSlip;

@Repository
public interface PaymentSlipRepository extends JpaRepository<PaymentSlip, Long> {
}