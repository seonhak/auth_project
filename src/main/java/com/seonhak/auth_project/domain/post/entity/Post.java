package com.seonhak.auth_project.domain.post.entity;

import com.seonhak.auth_project.domain.entity.Timestamped;
import com.seonhak.auth_project.domain.post.dto.PostRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public Post(PostRequest req){
        this.title = req.getTitle();
        this.content = req.getContent();
    }

    public void update(PostRequest req) {
        this.title = req.getTitle();
        this.content = req.getContent();
    }
}
