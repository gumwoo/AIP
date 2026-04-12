package com.example.AIProject.user.dto;

import com.example.AIProject.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String nickname;
    private String role;
    private LocalDateTime createdAt;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .role(user.getRole().getLabel())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
