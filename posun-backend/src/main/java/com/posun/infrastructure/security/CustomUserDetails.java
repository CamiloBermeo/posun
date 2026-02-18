package com.posun.infrastructure.security;

import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserClient;
import com.posun.domain.model.UserModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Esta clase sirve como puente entre mi model y la seguridad, hace que la seguridad o toque mi model
@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {

        private final UserModel user;

        private Collection<? extends GrantedAuthority> mapAuthorities(UserModel user){
            List<SimpleGrantedAuthority> roles= new ArrayList<>();
            if (user instanceof UserAdmin admin){
                roles.add(new SimpleGrantedAuthority("ROLE_" + admin.getUserPosition().name()));
            }else if (user instanceof UserClient client){
                roles.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
            }
            return roles;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.mapAuthorities(user);
        }

        @Override
        public String getPassword() {
            return user.getPassword().getValue();
        }

        @Override
        public String getUsername() {
            return user.getEmail().getValue();
        }

        public Long tenantId(){
            return user.getTenant().getTenantId();
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
