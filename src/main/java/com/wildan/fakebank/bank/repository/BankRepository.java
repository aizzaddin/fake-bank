package com.wildan.fakebank.bank.repository;

import com.wildan.fakebank.bank.entity.BankEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BankRepository extends JpaRepository<BankEntity, UUID> {
    Page<BankEntity> findByBankNameContainsIgnoreCase(String bankName, Pageable pageable);
}
