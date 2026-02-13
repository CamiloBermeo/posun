package com.posun.infrastructure.security;

import com.posun.domain.model.UserModel;
import com.posun.domain.repository.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final IUserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = recoverToken(request);
        if  (tokenJWT != null) {
            String subject = tokenService.getSubject(tokenJWT);
            UserModel userValidator = repository.findByEmail(subject);
            var authentication = new UsernamePasswordAuthenticationToken(userValidator, null, new CustomUserDetails(userValidator).getAuthorities());
            System.out.println("Esta es la info que lleva authentication " + authentication);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        return path.equals("/login") || path.equals("/login/createUser");
    }

    private String recoverToken(HttpServletRequest request){
        String authorizationHeader =  request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7).trim();
        }
        return null;
    }
}
