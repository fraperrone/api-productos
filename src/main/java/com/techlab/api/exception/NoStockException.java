package com.techlab.api.exception;

public class NoStockException extends RuntimeException {
    public NoStockException(String message) {
        super(message);
    }
}
