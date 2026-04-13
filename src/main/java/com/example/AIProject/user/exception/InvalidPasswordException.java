package com.example.AIProject.user.exception;

import com.example.AIProject.global.exception.CustomException;
import com.example.AIProject.global.exception.ErrorCode;

public class InvalidPasswordException extends CustomException {

    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
