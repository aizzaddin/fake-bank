package com.wildan.fakebank.auth.service;

import com.wildan.fakebank.auth.dto.AuthenticationRequest;
import com.wildan.fakebank.auth.dto.AuthenticationResponse;
import com.wildan.fakebank.useraccount.dto.RegisterUserRequest;

public interface AuthenticationService {
    AuthenticationResponse auth(AuthenticationRequest authenticationRequest);
    void register(RegisterUserRequest request);
}
