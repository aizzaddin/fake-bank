package com.wildan.fakebank.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "bank")
public class BankEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "bank_name", length = Integer.MAX_VALUE)
    private String bankName;

    @Column(name = "bank_code", length = Integer.MAX_VALUE)
    private String bankCode;

}