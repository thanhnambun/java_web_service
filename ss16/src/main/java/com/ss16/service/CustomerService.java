package com.ss16.service;

import com.ss16.model.dto.response.JWTResponse;
import com.ss16.model.entity.Customer;
import com.ss16.repo.CustomerRepository;
import com.ss16.security.jwt.JWTProvider;
import com.ss16.security.principal.CustomerPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtUtil;
    private final AuthenticationManager authManager;


    public String register(Customer customer) {

        if (customer.getUsername() == null || customer.getUsername().isBlank()) {
            throw new RuntimeException("Username không được để trống");
        }
        if (customer.getPassword() == null || customer.getPassword().length() < 6) {
            throw new RuntimeException("Password phải >= 6 ký tự");
        }
        if (customerRepository.existsByUsername(customer.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setIsLogin(false);
        customer.setStatus(true);

        customerRepository.save(customer);
        return "Đăng ký thành công";
    }

//    public JWTResponse login(String username, String password) {
//        Authentication auth = authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//        CustomerPrincipal user = (CustomerPrincipal) auth.getPrincipal();
//        String token = jwtUtil.generateToken(String.valueOf(user));
//        return new JWTResponse(token, "dummy-refresh-token");
//    }

    public String login(String username, String password) {
        Customer customer = customerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Sai username hoặc password"));

        if (!passwordEncoder.matches(password, customer.getPassword())) {
            throw new RuntimeException("Sai username hoặc password");
        }

        customer.setIsLogin(true);
        customerRepository.save(customer);

        return jwtUtil.generateToken(username);
    }


    public String logout(String username) {
        Customer customer = customerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User không tồn tại"));

        customer.setIsLogin(false);
        customerRepository.save(customer);

        return "Đăng xuất thành công";
    }


    public boolean checkDuplicate(String username, String email) {
        return customerRepository.existsByUsername(username) || customerRepository.existsByEmail(email);
    }
}
