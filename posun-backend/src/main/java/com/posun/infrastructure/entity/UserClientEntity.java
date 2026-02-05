package com.posun.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "users_clients")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@SuperBuilder
public class UserClientEntity extends UserEntity{


}