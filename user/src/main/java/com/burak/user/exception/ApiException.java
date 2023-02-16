package com.burak.user.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public record ApiException(String message,
                           Throwable throwable,
                           HttpStatus httpStatus,
                           ZonedDateTime timestamp
) {}