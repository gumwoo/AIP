package com.example.AIProject.post.service;

import com.example.AIProject.post.dto.CreatePostRequest;
import com.example.AIProject.post.dto.PostResponse;
import com.example.AIProject.post.dto.PostSummaryResponse;
import com.example.AIProject.post.dto.UpdatePostRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    PostResponse createPost(Long userId, CreatePostRequest request);

    Page<PostSummaryResponse> getPosts(Pageable pageable);

    PostResponse getPost(Long postId);

    PostResponse updatePost(Long userId, Long postId, UpdatePostRequest request);

    void deletePost(Long userId, Long postId);
}
