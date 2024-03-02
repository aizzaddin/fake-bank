package com.wildan.fakebank.userbalance.entity;

import com.wildan.fakebank.useraccount.entity.UserAccountEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_balance")
public class UserBalanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserAccountEntity user;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "currency")
    private String currency;
}