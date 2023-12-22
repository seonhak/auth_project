package com.seonhak.auth_project.domain.post.dto;

import com.seonhak.auth_project.domain.post.entity.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostResponse(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }
}
