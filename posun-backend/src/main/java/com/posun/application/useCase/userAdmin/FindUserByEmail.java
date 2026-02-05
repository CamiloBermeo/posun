package com.posun.application.useCase.userAdmin;

import com.posun.domain.repository.IUserAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class FindUserByEmail {
    private final IUserAdminRepository userAdminRepository;


}
