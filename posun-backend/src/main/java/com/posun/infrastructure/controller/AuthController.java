package com.posun.infrastructure.controller;

import com.posun.application.dto.authentication.AuthDataDTO;
import com.posun.application.dto.authentication.TokenDataDTO;
import com.posun.infrastructure.security.CustomUserDetails;
import com.posun.infrastructure.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDataDTO> logIn(@RequestBody AuthDataDTO dto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        String tokenJwt = tokenService.generateToken((CustomUserDetails) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDataDTO(tokenJwt));
    }


}
