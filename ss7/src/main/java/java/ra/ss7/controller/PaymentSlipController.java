package java.ra.ss7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.ra.ss7.entity.DataResponse;
import java.ra.ss7.entity.PaymentSlip;
import java.ra.ss7.service.PaymentSlipService;
import java.util.List;

@Controller
@RequestMapping("/paymentslips")
public class PaymentSlipController {

    @Autowired
    private PaymentSlipService paymentSlipService;

    // GET /paymentslips: Lấy danh sách tất cả phiếu chi
    @GetMapping
    public ResponseEntity<DataResponse<List<PaymentSlip>>> getPaymentSlips() {
        List<PaymentSlip> paymentSlips = paymentSlipService.getAllPaymentSlips();
        return new ResponseEntity<>(new DataResponse<>(paymentSlips, HttpStatus.OK), HttpStatus.OK);
    }

    // POST /paymentslips: Thêm phiếu chi mới
    @PostMapping
    public ResponseEntity<DataResponse<PaymentSlip>> addPaymentSlip(@Valid @RequestBody PaymentSlip paymentSlip) {
        PaymentSlip savedPaymentSlip = paymentSlipService.addPaymentSlip(paymentSlip);
        return new ResponseEntity<>(new DataResponse<>(savedPaymentSlip, HttpStatus.CREATED), HttpStatus.CREATED);
    }
}