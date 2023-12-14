package com.seonhak.auth_project.domain.user.dto;

import com.seonhak.auth_project.domain.user.entity.User;
import lombok.Getter;

@Getter
public class SignUpResponse {
    private String username;

    public SignUpResponse(User user) {
        this.username = user.getUsername();
    }
}
