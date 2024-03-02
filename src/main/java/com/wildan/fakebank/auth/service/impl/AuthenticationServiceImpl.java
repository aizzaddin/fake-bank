package com.wildan.fakebank.auth.service.impl;

import com.wildan.fakebank.auth.dto.AuthenticationRequest;
import com.wildan.fakebank.auth.dto.AuthenticationResponse;
import com.wildan.fakebank.auth.service.AuthenticationService;
import com.wildan.fakebank.config.JwtService;
import com.wildan.fakebank.useraccount.dto.RegisterUserRequest;
import com.wildan.fakebank.useraccount.entity.UserAccountEntity;
import com.wildan.fakebank.useraccount.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserAccountService userAccountService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse auth(AuthenticationRequest reques) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        reques.getEmail(),
                        reques.getPassword()
                )
        );

        UserAccountEntity userAccount = userAccountService.getUserAccountByEmail(reques.getEmail());
        String jwtToken = jwtService.generateToken(userAccount);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public void register(RegisterUserRequest request) {
        userAccountService.register(request);
    }
}
