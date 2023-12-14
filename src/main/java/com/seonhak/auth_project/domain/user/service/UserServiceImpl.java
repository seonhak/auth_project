package com.seonhak.auth_project.domain.user.service;

import com.seonhak.auth_project.domain.user.dto.SignUpRequest;
import com.seonhak.auth_project.domain.user.dto.SignUpResponse;
import com.seonhak.auth_project.domain.user.entity.User;
import com.seonhak.auth_project.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Object> signUp(SignUpRequest req) {
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("이미 가입된 아이디입니다.");
        }
        String username = req.getUsername();
        String password = passwordEncoder.encode(req.getPassword());
        User user = new User(username, password);
        userRepository.save(user);

        SignUpResponse res = new SignUpResponse(user);
        return ResponseEntity.ok().body(res.getUsername() + "님이 회원가입에 성공했습니다!");
    }

}
