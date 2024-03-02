package com.wildan.fakebank.userbalance.service;

import com.wildan.fakebank.userbalance.dto.AddBalanceRequest;
import com.wildan.fakebank.userbalance.dto.UserBalanceResponse;

public interface BalanceService {
    UserBalanceResponse getBalance(String userEmail);
    UserBalanceResponse addBalance(AddBalanceRequest request, String userEmail);
}
