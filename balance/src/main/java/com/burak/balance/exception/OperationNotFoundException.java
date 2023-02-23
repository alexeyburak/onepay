package com.burak.balance.exception;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public class OperationNotFoundException extends RuntimeException {
    public OperationNotFoundException(String message) {
        super(message);
    }
}
