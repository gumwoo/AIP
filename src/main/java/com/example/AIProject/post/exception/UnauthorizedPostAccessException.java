package com.example.AIProject.post.exception;

import com.example.AIProject.global.exception.CustomException;
import com.example.AIProject.global.exception.ErrorCode;

public class UnauthorizedPostAccessException extends CustomException {

    public UnauthorizedPostAccessException() {
        super(ErrorCode.UNAUTHORIZED_POST_ACCESS);
    }
}
