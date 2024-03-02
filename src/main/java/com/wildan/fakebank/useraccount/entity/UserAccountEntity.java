package com.wildan.fakebank.useraccount.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_account")
public class UserAccountEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 100)
    @Column(name = "first_name", length = 100)
    private String firstName;

    @Size(max = 100)
    @Column(name = "last_name", length = 100)
    private String lastName;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password", length = Integer.MAX_VALUE)
    private String password;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Column(name = "kelurahan", length = Integer.MAX_VALUE)
    private String kelurahan;

    @Column(name = "kecamatan", length = Integer.MAX_VALUE)
    private String kecamatan;

    @Column(name = "kota", length = Integer.MAX_VALUE)
    private String kota;

    @Column(name = "provinsi", length = Integer.MAX_VALUE)
    private String provinsi;

    @Size(max = 10)
    @Column(name = "account_number", length = 10)
    private String accountNumber;

    @Size(max = 16)
    @Column(name = "card_number", length = 16)
    private String cardNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "role", length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }
}