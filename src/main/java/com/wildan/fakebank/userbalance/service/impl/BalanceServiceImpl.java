package com.wildan.fakebank.userbalance.service.impl;

import com.wildan.fakebank.useraccount.service.UserAccountService;
import com.wildan.fakebank.userbalance.dto.AddBalanceRequest;
import com.wildan.fakebank.userbalance.dto.UserBalanceResponse;
import com.wildan.fakebank.userbalance.entity.UserBalanceEntity;
import com.wildan.fakebank.userbalance.repository.UserBalanceRepository;
import com.wildan.fakebank.userbalance.service.BalanceService;
import com.wildan.fakebank.usertransaction.service.UserTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final UserBalanceRepository userBalanceRepository;
    private final UserAccountService userAccountService;
    private final UserTransactionService userTransactionService;

    @Override
    public UserBalanceResponse getBalance(String userEmail) {
        UserBalanceEntity userBalance = userBalanceRepository.findByUser_Email(userEmail);
        if (userBalance == null) {
            UserBalanceEntity newBalance = new UserBalanceEntity();
            newBalance.setUser(userAccountService.getUserAccountByEmail(userEmail));
            newBalance.setBalance(0);
            newBalance.setCurrency("IDR");
            userBalanceRepository.save(newBalance);
        }
        return UserBalanceResponse
                .builder()
                .firstName(userBalance.getUser().getFirstName())
                .currency(userBalance.getCurrency())
                .accountNumber(userBalance.getUser().getAccountNumber())
                .balance(userBalance.getBalance().toString())
                .build();
    }

    @Override
    public UserBalanceResponse addBalance(AddBalanceRequest request, String userEmail) {
        UserBalanceEntity userBalance = userBalanceRepository.findByUser_Email(userEmail);
        userBalance.setBalance(userBalance.getBalance() + request.getNominal());

        userTransactionService.addTransactionHistory(request, userBalance.getUser());
        userBalanceRepository.save(userBalance);
        return UserBalanceResponse
                .builder()
                .firstName(userBalance.getUser().getFirstName())
                .currency(userBalance.getCurrency())
                .accountNumber(userBalance.getUser().getAccountNumber())
                .balance(userBalance.getBalance().toString())
                .build();
    }
}
