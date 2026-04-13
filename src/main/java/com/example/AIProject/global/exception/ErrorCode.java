package com.example.AIProject.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 공통
    INVALID_INPUT("C001", "입력값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    INTERNAL_ERROR("C999", "서버 내부 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

    // 유저
    USER_NOT_FOUND("U001", "존재하지 않는 유저입니다.", HttpStatus.NOT_FOUND),
    DUPLICATE_EMAIL("U002", "이미 사용 중인 이메일입니다.", HttpStatus.CONFLICT),
    INVALID_PASSWORD("U003", "비밀번호가 올바르지 않습니다.", HttpStatus.UNAUTHORIZED),

    // 게시글
    POST_NOT_FOUND("P001", "존재하지 않는 게시글입니다.", HttpStatus.NOT_FOUND),
    UNAUTHORIZED_POST_ACCESS("P002", "게시글을 수정/삭제할 권한이 없습니다.", HttpStatus.FORBIDDEN);

    private final String code;
    private final String message;
    private final HttpStatus status;
}
