package com.posun.infrastructure.security;

import com.posun.domain.model.UserAdmin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        try {
            UserAdmin userAdmin = findUserByUserName.execute(userName);
            return new CustomUserDetails(userAdmin);

        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException("Usuario no encontrado" + userName);
        }

    }

}
