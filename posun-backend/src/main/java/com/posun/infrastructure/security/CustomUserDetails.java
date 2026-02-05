package com.posun.infrastructure.security;

import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

//Esta clase sirve como puente entre mi model y la seguridad, hace que la seguridad o toque mi model
@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {

        private final UserModel user;


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        }

        @Override
        public String getPassword() {
            return user.getPassword().getValue();
        }

        @Override
        public String getUsername() {
            return user.getEmail().getValue();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            if (user instanceof UserAdmin admin){
                return admin.getStatus().getValue();
            }
            return true;
        }

}
