package com.example.test_for_UnitBean.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String login;
    private String password;
}
