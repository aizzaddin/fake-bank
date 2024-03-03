package com.wildan.fakebank.bank.service;

import java.util.Map;

public interface BankService {
    Map<String, Object> getListBank(int pageNumber, int pageSize, String search);
}
