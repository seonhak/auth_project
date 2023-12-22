package com.seonhak.auth_project.domain.user.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;
}
