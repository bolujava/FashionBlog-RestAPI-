package com.boluwatifeproj.fashionblog.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
public class PostNotFoundException extends Exception{
    private String message;

    public PostNotFoundException(String message) {
        this.message = message;
    }
}
