package com.burak.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message) {
        super(message);
    }
}
