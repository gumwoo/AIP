package com.example.AIProject.post.exception;

import com.example.AIProject.global.exception.CustomException;
import com.example.AIProject.global.exception.ErrorCode;

public class PostNotFoundException extends CustomException {

    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
