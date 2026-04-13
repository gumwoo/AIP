package com.example.AIProject.user.service;

import com.example.AIProject.user.dto.LoginRequest;
import com.example.AIProject.user.dto.RegisterRequest;
import com.example.AIProject.user.dto.TokenResponse;
import com.example.AIProject.user.dto.UserResponse;
import com.example.AIProject.user.entity.User;
import com.example.AIProject.user.exception.DuplicateEmailException;
import com.example.AIProject.user.exception.InvalidPasswordException;
import com.example.AIProject.user.exception.UserNotFoundException;
import com.example.AIProject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException();
        }

        User user = User.create(
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getNickname()
        );

        return UserResponse.from(userRepository.save(user));
    }

    @Override
    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException();
        }

        // TODO: JWT 토큰 발급 - Security 단계에서 구현
        throw new UnsupportedOperationException("JWT 구현 후 완성");
    }

    @Override
    public UserResponse getMyInfo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        return UserResponse.from(user);
    }
}
