package com.wildan.fakebank.usertransaction.controller;

import com.wildan.fakebank.usertransaction.dto.UserTransactionResponse;
import com.wildan.fakebank.usertransaction.service.UserTransactionService;
import com.wildan.fakebank.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/transaction")
@RequiredArgsConstructor
public class UserTransactionController {
    private final UserTransactionService userTransactionService;

    @GetMapping("/history")
    public ResponseEntity<Object> getUserTransactionHistory(Authentication auth) {
        List<UserTransactionResponse> response = userTransactionService
                .getUserTransaction(auth.getName());
        return ResponseHandler
                .successResponse(response);
    }
}
