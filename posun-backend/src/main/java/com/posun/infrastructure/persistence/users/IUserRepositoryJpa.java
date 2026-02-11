package com.posun.infrastructure.persistence.users;

import com.posun.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepositoryJpa extends JpaRepository<UserEntity, Long> {

    UserEntity  findByEmail(String email);

}
