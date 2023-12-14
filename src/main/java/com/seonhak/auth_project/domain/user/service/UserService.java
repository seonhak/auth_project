package com.seonhak.auth_project.domain.user.service;

import com.seonhak.auth_project.domain.user.dto.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<Object> signUp(SignUpRequest req);
}
