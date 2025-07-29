package com.ss16.security.principal;
import com.ss16.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class CustomerPrincipal implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final String email;
    private final String fullName;
    private final String phone;
    private final Boolean isLogin;
    private final Boolean status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }

    public static CustomerPrincipal fromCustomer(Customer customer) {
        return CustomerPrincipal.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .password(customer.getPassword())
                .email(customer.getEmail())
                .fullName(customer.getFullName())
                .phone(customer.getPhone())
                .isLogin(customer.getIsLogin())
                .status(customer.getStatus())
                .build();
    }
}
