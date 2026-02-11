package com.posun.domain.repository;

import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserModel;

public interface IUserRepository {
    UserModel findByEmail(String email);
}
