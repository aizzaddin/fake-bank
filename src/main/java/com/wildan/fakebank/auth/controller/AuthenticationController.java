package com.wildan.fakebank.auth.controller;

import com.wildan.fakebank.auth.dto.AuthenticationRequest;
import com.wildan.fakebank.auth.dto.AuthenticationResponse;
import com.wildan.fakebank.auth.service.AuthenticationService;
import com.wildan.fakebank.useraccount.dto.RegisterUserRequest;
import com.wildan.fakebank.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(
            @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse response = authenticationService.auth(request);
        return ResponseHandler.successResponse(response);
    }


    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(
            @RequestBody RegisterUserRequest request
    ) {
        authenticationService.register(request);
        return ResponseHandler.successResponseWithoutData();
    }
}
