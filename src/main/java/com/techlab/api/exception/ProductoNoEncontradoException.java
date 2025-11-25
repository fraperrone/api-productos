package com.techlab.api.exception;

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(String message) {
        super(message);
    }
}
