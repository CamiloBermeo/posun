package com.posun.infrastructure.entity;

import com.posun.domain.model.TenantConfig;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;
import com.posun.domain.valueObject.UserAdmin.PhoneNumberVO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_admins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class UserAdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenantId;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(length = 20)
    private String passwordHash;
    @Column(nullable = false)
    private boolean active = true;

}
