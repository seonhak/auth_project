package com.seonhak.auth_project.domain.post.controller;

import com.seonhak.auth_project.domain.common.CommonResponse;
import com.seonhak.auth_project.domain.post.dto.PostRequest;
import com.seonhak.auth_project.domain.post.dto.PostResponse;
import com.seonhak.auth_project.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequest req){
        PostResponse res;
        try{
            res = postService.createPost(req);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/posts")
    public List<PostResponse> getPostList(){
        return postService.getPostList();
    }

    @GetMapping("/post/{postId}")
    public PostResponse getPost(@PathVariable Long postId){
        PostResponse res = postService.getPost(postId);
        return res;
    }

    @PatchMapping("/post/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Long postId, @RequestBody PostRequest req){
        PostResponse res;
        try{
            res = postService.updatePost(postId, req);
            return ResponseEntity.ok().body(res);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.ok().body(new CommonResponse(HttpStatus.OK.value(), "정상적으로 삭제됐습니다."));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new CommonResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));        }
    }
}
