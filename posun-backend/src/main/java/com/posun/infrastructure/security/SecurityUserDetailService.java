package com.posun.infrastructure.security;

import com.posun.application.useCase.users.FindUserByEmailUseCase;
import com.posun.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUserDetailService implements UserDetailsService {

    private final FindUserByEmailUseCase findUserByEmail;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try {
            UserModel user = findUserByEmail.execute(email);
            return new CustomUserDetails(user);

        } catch (IllegalAccessError e) {
            throw new UsernameNotFoundException("Usuario no encontrado" + email);
        }

    }

}
