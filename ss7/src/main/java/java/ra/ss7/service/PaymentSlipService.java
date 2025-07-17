package java.ra.ss7.service;


import java.ra.ss7.entity.PaymentSlip;
import java.util.List;

public interface PaymentSlipService {
    List<PaymentSlip> getAllPaymentSlips();
    PaymentSlip getPaymentSlipById(Long id);
    PaymentSlip addPaymentSlip(PaymentSlip paymentSlip);
}