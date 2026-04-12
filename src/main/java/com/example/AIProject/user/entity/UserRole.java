package com.example.AIProject.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    USER("USER", "일반회원"),
    ADMIN("ADMIN", "관리자");

    private final String code;
    private final String label;
}
