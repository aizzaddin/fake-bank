package com.wildan.fakebank.usertransaction.service.impl;

import com.wildan.fakebank.useraccount.entity.UserAccountEntity;
import com.wildan.fakebank.userbalance.dto.AddBalanceRequest;
import com.wildan.fakebank.usertransaction.dto.UserTransactionResponse;
import com.wildan.fakebank.usertransaction.entity.SourceEnum;
import com.wildan.fakebank.usertransaction.entity.UserTransactionEntity;
import com.wildan.fakebank.usertransaction.repository.UserTransactionRepository;
import com.wildan.fakebank.usertransaction.service.UserTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserTransactionServiceImpl implements UserTransactionService {
    private final UserTransactionRepository userTransactionRepository;
    private static final String ALLOWED_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int TRANSACTION_CODE_LENGTH = 16;
    private static SecureRandom random = new SecureRandom();
    @Override
    public void addTransactionHistory(AddBalanceRequest request, UserAccountEntity userAccount) {
        String transactionCode = generateTransactionCode();
        userTransactionRepository.save(UserTransactionEntity
                .builder()
                        .user(userAccount)
                        .nominal(request.getNominal())
                        .currency("IDR")
                        .source(SourceEnum.valueOf(request.getSource()))
                        .transactionCode(transactionCode)
                        .created_at(LocalDateTime.now())
                .build());
    }

    @Override
    public List<UserTransactionResponse> getUserTransaction(String userEmail) {
        List<UserTransactionEntity> list = userTransactionRepository.findByUser_Email(userEmail);
        return list
                .stream().map(d -> UserTransactionResponse
                        .builder()
                        .transactionCode(d.getTransactionCode())
                        .nominal(d.getNominal())
                        .source(d.getSource().toString())
                        .currency(d.getCurrency())
                        .build())
                .collect(Collectors.toList());
    }

    private static String generateTransactionCode() {
        StringBuilder sb = new StringBuilder(TRANSACTION_CODE_LENGTH);
        for (int i = 0; i < TRANSACTION_CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            sb.append(ALLOWED_CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
