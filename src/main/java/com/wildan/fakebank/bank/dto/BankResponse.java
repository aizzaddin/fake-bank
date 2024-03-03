package com.wildan.fakebank.bank.dto;

import com.wildan.fakebank.bank.entity.BankEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankResponse {
    private String bank_name;
    private String bank_code;

    public static BankResponse of(BankEntity bank) {
        return BankResponse
                .builder()
                .bank_name(bank.getBankName())
                .bank_code(bank.getBankCode())
                .build();
    }
}
