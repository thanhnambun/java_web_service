package com.ss16.controller;

import com.ss16.model.dto.request.LoginRequest;
import com.ss16.model.dto.response.APIResponse;
import com.ss16.model.dto.response.JWTResponse;
import com.ss16.model.entity.Customer;
import com.ss16.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse<String>> register(@RequestBody @Valid Customer customer) {
        customerService.register(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                APIResponse.<String>builder()
                        .success(true)
                        .message("Đăng ký thành công")
                        .status(HttpStatus.CREATED)
                        .data(null)
                        .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> login(@RequestBody LoginRequest request) {
        customerService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(
                APIResponse.<String>builder()
                        .success(true)
                        .message("Đăng nhập thành công")
                        .status(HttpStatus.OK)
                        .data(null)
                        .build()
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<APIResponse<String>> logout(@RequestBody String username) {
        customerService.logout(username);
        return ResponseEntity.ok(
                APIResponse.<String>builder()
                        .success(true)
                        .message("Đăng xuất thành công")
                        .status(HttpStatus.OK)
                        .data(null)
                        .build()
        );
    }
}

