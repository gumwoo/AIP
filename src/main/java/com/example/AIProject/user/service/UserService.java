package com.example.AIProject.user.service;

import com.example.AIProject.user.dto.LoginRequest;
import com.example.AIProject.user.dto.RegisterRequest;
import com.example.AIProject.user.dto.TokenResponse;
import com.example.AIProject.user.dto.UserResponse;

public interface UserService {

    UserResponse register(RegisterRequest request);

    TokenResponse login(LoginRequest request);

    UserResponse getMyInfo(Long userId);
}
