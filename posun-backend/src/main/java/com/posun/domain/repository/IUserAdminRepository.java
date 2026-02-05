package com.posun.domain.repository;

import com.posun.domain.model.UserAdmin;

public interface IUserAdminRepository {
    UserAdmin findByEmail(String email);
}
