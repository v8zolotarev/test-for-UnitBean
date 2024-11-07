package com.example.test_for_UnitBean.controller;

import com.example.test_for_UnitBean.dto.AuthenticationRequest;
import com.example.test_for_UnitBean.dto.AuthenticationResponse;
import com.example.test_for_UnitBean.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authService.login(request.getLogin());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refresh(@RequestBody String refreshToken) {
        String newAccessToken = authService.getAccessTokenByRefreshToken(refreshToken);
        return ResponseEntity.ok(newAccessToken);
    }
}
