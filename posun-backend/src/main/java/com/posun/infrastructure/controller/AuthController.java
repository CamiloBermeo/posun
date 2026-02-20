package com.posun.infrastructure.controller;

import com.posun.application.dto.authentication.AuthDataDTO;
import com.posun.application.dto.authentication.TokenDataDTO;
import com.posun.domain.model.RefreshToken;
import com.posun.infrastructure.security.CustomUserDetails;
import com.posun.infrastructure.security.RefreshTokenService;
import com.posun.infrastructure.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDataDTO> logIn(@RequestBody AuthDataDTO dto, @AuthenticationPrincipal CustomUserDetails customUserDetails) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        String accessToken= tokenService.generateToken((CustomUserDetails) authentication.getPrincipal());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(customUserDetails.getUser().getUserId());
        return ResponseEntity.ok(new TokenDataDTO(accessToken));
    }

    public ResponseEntity<RefreshTokenDTO> refreshToken (){

    }

}
