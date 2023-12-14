package com.seonhak.auth_project.domain.user.controller;

import com.seonhak.auth_project.domain.user.dto.SignUpRequest;
import com.seonhak.auth_project.domain.user.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    public final UserServiceImpl userServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest req, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorList.add(fieldError.getField() + " error : " + fieldError.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorList);
        }
        return ResponseEntity.ok().body(userServiceImpl.signUp(req).getBody());
    }
}
