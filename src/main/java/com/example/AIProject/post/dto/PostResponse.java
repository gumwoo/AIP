package com.example.AIProject.post.dto;

import com.example.AIProject.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponse {

    private Long id;
    private Long userId;
    private String title;
    private String content;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .content(post.getContent())
                .viewCount(post.getViewCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
