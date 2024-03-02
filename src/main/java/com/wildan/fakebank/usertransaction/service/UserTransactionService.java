package com.wildan.fakebank.usertransaction.service;

import com.wildan.fakebank.useraccount.entity.UserAccountEntity;
import com.wildan.fakebank.userbalance.dto.AddBalanceRequest;
import com.wildan.fakebank.usertransaction.dto.UserTransactionResponse;

import java.util.List;

public interface UserTransactionService {
    void addTransactionHistory(AddBalanceRequest request, UserAccountEntity userAccount);
    List<UserTransactionResponse> getUserTransaction(String userEmail);
}
