package com.posun.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED) // O SINGLE_TABLE si prefieres rendimiento
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    @Setter(AccessLevel.PROTECTED)
    private TenantEntity tenant;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

}
