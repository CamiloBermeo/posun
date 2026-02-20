package com.posun.infrastructure.entity;

import com.posun.domain.model.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Builder
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class RefreshTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users", referencedColumnName = "id")
    private UserModel user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;
}