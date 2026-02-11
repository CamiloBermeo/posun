package com.posun.application.useCase.users;

import com.posun.domain.model.UserModel;
import com.posun.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByEmailUseCase {
    private final IUserRepository userAdminRepository;

    public UserModel  execute(String email){

    return userAdminRepository.findByEmail(email);
    }
}
