package com.wildan.fakebank.usertransaction.repository;

import com.wildan.fakebank.usertransaction.entity.UserTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransactionEntity, UUID> {
    List<UserTransactionEntity> findByUser_Email(String email);
}