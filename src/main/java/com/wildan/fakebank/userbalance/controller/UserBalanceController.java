package com.wildan.fakebank.userbalance.controller;

import com.wildan.fakebank.userbalance.dto.AddBalanceRequest;
import com.wildan.fakebank.userbalance.dto.UserBalanceResponse;
import com.wildan.fakebank.userbalance.service.BalanceService;
import com.wildan.fakebank.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user-balance")
@RequiredArgsConstructor
public class UserBalanceController {
    private final BalanceService balanceService;

    @GetMapping("")
    public ResponseEntity<Object> getBalance(Authentication auth) {
        UserBalanceResponse response = balanceService.getBalance(auth.getName());
        return ResponseHandler.successResponse(response);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addBalance(@RequestBody AddBalanceRequest request, Authentication auth) {
        UserBalanceResponse response = balanceService.addBalance(request, auth.getName());
        return ResponseHandler.successResponse(response);
    }
}
