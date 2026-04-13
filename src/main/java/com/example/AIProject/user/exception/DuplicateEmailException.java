package com.example.AIProject.user.exception;

import com.example.AIProject.global.exception.CustomException;
import com.example.AIProject.global.exception.ErrorCode;

public class DuplicateEmailException extends CustomException {

    public DuplicateEmailException() {
        super(ErrorCode.DUPLICATE_EMAIL);
    }
}
