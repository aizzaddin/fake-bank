package com.wildan.fakebank.bank.service.impl;

import com.wildan.fakebank.bank.dto.BankResponse;
import com.wildan.fakebank.bank.entity.BankEntity;
import com.wildan.fakebank.bank.repository.BankRepository;
import com.wildan.fakebank.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    @Override
    public Map<String, Object> getListBank(int pageNumber, int pageSize, String search) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<BankEntity> data;
        if (search != null) {
            data = bankRepository.findByBankNameContainsIgnoreCase(search, pageable);
        } else {
            data = bankRepository.findAll(pageable);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("data", data.stream().map(BankResponse::of));
        response.put("current_page", data.getNumber());
        response.put("total_items", data.getTotalElements());
        response.put("total_pages", data.getTotalPages());

        return response;
    }
}
