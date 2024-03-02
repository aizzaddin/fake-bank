package com.wildan.fakebank.useraccount.service;

import com.wildan.fakebank.useraccount.dto.ProfileResponse;
import com.wildan.fakebank.useraccount.dto.RegisterUserRequest;
import com.wildan.fakebank.useraccount.entity.UserAccountEntity;

public interface UserAccountService {
    UserAccountEntity getUserAccountByEmail(String email);
    void register(RegisterUserRequest request);
    void save(UserAccountEntity userAccount);
    ProfileResponse getProfile(String email);
}
