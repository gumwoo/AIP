package com.example.AIProject.post.dto;

import com.example.AIProject.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostSummaryResponse {

    private Long id;
    private Long userId;
    private String title;
    private int viewCount;
    private LocalDateTime createdAt;

    public static PostSummaryResponse from(Post post) {
        return PostSummaryResponse.builder()
                .id(post.getId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .viewCount(post.getViewCount())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
