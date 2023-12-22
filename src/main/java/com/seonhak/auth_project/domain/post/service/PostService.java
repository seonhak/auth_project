package com.seonhak.auth_project.domain.post.service;

import com.seonhak.auth_project.domain.common.CommonResponse;
import com.seonhak.auth_project.domain.post.dto.PostRequest;
import com.seonhak.auth_project.domain.post.dto.PostResponse;
import com.seonhak.auth_project.domain.post.entity.Post;
import com.seonhak.auth_project.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponse createPost(PostRequest req) {
        Post post = new Post(req);
        postRepository.save(post);
        return new PostResponse(post);
    }

    public List<PostResponse> getPostList() {
        List<PostResponse> res = new ArrayList<>();
        res = postRepository.findAll().stream().map(PostResponse::new).toList();
        return res;
    }

    public PostResponse updatePost(Long postId, PostRequest req) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new RuntimeException("해당 게시글이 존재하지 않습니다.")
        );
        post.update(req);
        return new PostResponse(post);
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new RuntimeException("해당 게시글이 존재하지 않습니다.")
        );
        postRepository.delete(post);
    }

    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new RuntimeException("해당 게시글이 존재하지 않습니다.")
        );
        PostResponse res = new PostResponse(post);
        return res;
    }
}
