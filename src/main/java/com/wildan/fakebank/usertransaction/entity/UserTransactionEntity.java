package com.wildan.fakebank.usertransaction.entity;

import com.wildan.fakebank.useraccount.entity.UserAccountEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_transaction")
public class UserTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserAccountEntity user;

    @Column(name = "currency")
    private String currency;

    @Column(name = "nominal")
    private Integer nominal;

    @Column(name = "source")
    @Enumerated(EnumType.STRING)
    private SourceEnum source;

    @Column(name = "transaction_code")
    private String transactionCode;

    @Column(name = "created_at")
    private LocalDateTime created_at;
}