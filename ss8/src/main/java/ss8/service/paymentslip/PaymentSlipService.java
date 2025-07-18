package ss8.service.paymentslip;


import ss8.model.dto.PaymentSlipDTO;

import java.util.List;

public interface PaymentSlipService{
    PaymentSlipDTO create(PaymentSlipDTO dto);
    PaymentSlipDTO update(Long id, PaymentSlipDTO dto);
    void delete(Long id);
    List<PaymentSlipDTO> findAll();
}