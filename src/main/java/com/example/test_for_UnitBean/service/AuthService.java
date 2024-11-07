package com.example.test_for_UnitBean.service;

import com.example.test_for_UnitBean.dto.AuthenticationResponse;
import com.example.test_for_UnitBean.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationResponse login(String username) {
        String accessToken = jwtTokenProvider.createAccessToken(username);
        String refreshToken = jwtTokenProvider.createRefreshToken(username);

        return new AuthenticationResponse(accessToken, refreshToken);
    }

    public String getAccessTokenByRefreshToken(String refreshToken) {
        if (jwtTokenProvider.validateToken(refreshToken)) {
            String username = jwtTokenProvider.getUsernameFromToken(refreshToken);
            return jwtTokenProvider.createAccessToken(username);
        } else {
            throw new IllegalArgumentException("Invalid refresh token");
        }
    }
}
