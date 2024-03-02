package com.wildan.fakebank.userbalance.repository;

import com.wildan.fakebank.userbalance.entity.UserBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserBalanceRepository extends JpaRepository<UserBalanceEntity, UUID> {
    UserBalanceEntity findByUser_Email(String email);
}