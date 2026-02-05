package com.posun.infrastructure.entity;


import com.posun.domain.model.UserPosition;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "user_admins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@SuperBuilder
public class UserAdminEntity extends UserEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private UserPosition userPosition;

    @Column(nullable = false)
    private boolean active = true;

}