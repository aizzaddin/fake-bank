package com.wildan.fakebank.bank.controller;

import com.wildan.fakebank.bank.service.BankService;
import com.wildan.fakebank.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bank")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("")
    public ResponseEntity<Object> getListBank(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "search", required = false) String search
    ) {
        return ResponseHandler
                .successResponse(bankService.getListBank(page, size, search));
    }
}
