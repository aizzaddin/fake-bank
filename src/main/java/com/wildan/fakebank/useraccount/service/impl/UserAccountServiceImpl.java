package com.wildan.fakebank.useraccount.service.impl;

import com.wildan.fakebank.exception.ErrorException;
import com.wildan.fakebank.useraccount.dto.ProfileResponse;
import com.wildan.fakebank.useraccount.dto.RegisterUserRequest;
import com.wildan.fakebank.useraccount.entity.Role;
import com.wildan.fakebank.useraccount.entity.UserAccountEntity;
import com.wildan.fakebank.useraccount.repository.UserAccountRepository;
import com.wildan.fakebank.useraccount.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAccountEntity getUserAccountByEmail(String email) {
        return userAccountRepository.findByEmail(email)
                .orElseThrow(() -> new ErrorException("User Not Found"));
    }

    @Override
    public void register(RegisterUserRequest request) {
        Optional<UserAccountEntity> userAccount = userAccountRepository.findByEmail(request.getEmail());
        if (userAccount.isEmpty()) {
            save(UserAccountEntity
                    .builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .phoneNumber(request.getPhoneNumber())
                    .password(passwordEncoder.encode(request.getNewPassword()))
                    .address(request.getAddress())
                    .kelurahan(request.getKelurahan())
                    .kecamatan(request.getKecamatan())
                    .kota(request.getKota())
                    .provinsi(request.getProvinsi())
                    .accountNumber(generateAccountNumber())
                    .cardNumber(generateCardNumber())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .role(Role.USER)
                    .build());
        } else {
            throw new ErrorException("Email already registered");
        }
    }

    @Override
    public void save(UserAccountEntity userAccount) {
        userAccountRepository.save(userAccount);
    }

    @Override
    public ProfileResponse getProfile(String email) {
        UserAccountEntity userAccountEntity = getUserAccountByEmail(email);
        return ProfileResponse.of(userAccountEntity);
    }

    private static String generateAccountNumber() {
        StringBuilder sb = new StringBuilder(10);
        Random random = new Random();
        String number = "0123456789";
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(number.length());
            sb.append(number.charAt(index));
        }
        return sb.toString();
    }

    private static String generateCardNumber() {
        StringBuilder sb = new StringBuilder(15);
        Random random = new Random();
        String number = "0123456789";
        sb.append("4");
        for (int i = 0; i < 15; i++) {
            int index = random.nextInt(number.length());
            sb.append(number.charAt(index));
        }
        return sb.toString();
    }
}
