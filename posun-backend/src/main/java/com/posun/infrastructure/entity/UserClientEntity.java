package com.posun.infrastructure.entity;

import com.posun.domain.valueObject.UserAdmin.PasswordVO;
import com.posun.domain.valueObject.UserClient.LastNameVO;
import com.posun.domain.valueObject.UserClient.NameVO;
import com.posun.domain.valueObject.UserClient.PhoneNumberVO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class UserClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String phoneNumber;
    @Column(nullable = false, length = 100)
    private String passwordHash;

}
