package com.example.AIProject.post.service;

import com.example.AIProject.post.dto.CreatePostRequest;
import com.example.AIProject.post.dto.PostResponse;
import com.example.AIProject.post.dto.PostSummaryResponse;
import com.example.AIProject.post.dto.UpdatePostRequest;
import com.example.AIProject.post.entity.Post;
import com.example.AIProject.post.exception.PostNotFoundException;
import com.example.AIProject.post.exception.UnauthorizedPostAccessException;
import com.example.AIProject.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostResponse createPost(Long userId, CreatePostRequest request) {
        Post post = Post.create(userId, request.getTitle(), request.getContent());
        return PostResponse.from(postRepository.save(post));
    }

    @Override
    public Page<PostSummaryResponse> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(PostSummaryResponse::from);
    }

    @Override
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        post.increaseViewCount();
        return PostResponse.from(post);
    }

    @Override
    public PostResponse updatePost(Long userId, Long postId, UpdatePostRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        validateOwner(userId, post);
        post.update(request.getTitle(), request.getContent());
        return PostResponse.from(post);
    }

    @Override
    public void deletePost(Long userId, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        validateOwner(userId, post);
        postRepository.delete(post);
    }

    private void validateOwner(Long userId, Post post) {
        if (!post.getUserId().equals(userId)) {
            throw new UnauthorizedPostAccessException();
        }
    }
}
