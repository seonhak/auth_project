package com.seonhak.auth_project.domain.user.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignUpRequest {
    @Valid
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,14}$",
            message = "아이디는 영어와 숫자를 포함한 8~14자 문자열이어야 합니다.")
    private String username;
    @Valid
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,14}$",
            message = "비밀번호는 영어와 숫자, 특수문자 !@#$%^&*을 포함한 8~14자 문자열이어야 합니다.")
    private String password;
}
