package com.wildan.fakebank.useraccount.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.wildan.fakebank.useraccount.entity.UserAccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProfileResponse {
    private String firstName;
    private String lastName;
    private String accountNumber;
    private String cardNumber;
    private String email;
    private String phoneNumber;
    private String address;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private String provinsi;

    public static ProfileResponse of(UserAccountEntity userAccountEntity) {
        return ProfileResponse
                .builder()
                .firstName(userAccountEntity.getFirstName())
                .lastName(userAccountEntity.getLastName())
                .accountNumber(userAccountEntity.getAccountNumber())
                .cardNumber(userAccountEntity.getCardNumber())
                .email(userAccountEntity.getEmail())
                .phoneNumber(userAccountEntity.getPhoneNumber())
                .address(userAccountEntity.getAddress())
                .kelurahan(userAccountEntity.getKelurahan())
                .kecamatan(userAccountEntity.getKecamatan())
                .kota(userAccountEntity.getKota())
                .provinsi(userAccountEntity.getProvinsi())
                .build();
    }
}
