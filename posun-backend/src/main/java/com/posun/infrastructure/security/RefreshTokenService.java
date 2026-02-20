package com.posun.infrastructure.security;

import com.posun.domain.model.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    @Value("${jwt.refresh-expiration-ms}")
    private Long refreshTokenDurationMs;

    public RefreshToken createRefreshToken(Long userId ){
        RefreshToken.RefreshTokenBuilder refreshTokenBuilder = RefreshToken.builder()
                .withUser();
    }
}
