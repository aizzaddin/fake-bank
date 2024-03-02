package com.wildan.fakebank.useraccount.controller;

import com.wildan.fakebank.useraccount.dto.ProfileResponse;
import com.wildan.fakebank.useraccount.service.UserAccountService;
import com.wildan.fakebank.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user-account")
@RequiredArgsConstructor
@Slf4j
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping("/profile")
    public ResponseEntity<Object> getUserAccountDetails(Authentication auth) {
        ProfileResponse response = userAccountService.getProfile(auth.getName());
        return ResponseHandler.successResponse(response);
    }
}
