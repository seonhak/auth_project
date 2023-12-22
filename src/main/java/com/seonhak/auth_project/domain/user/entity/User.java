package com.seonhak.auth_project.domain.user.entity;


import com.seonhak.auth_project.domain.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
