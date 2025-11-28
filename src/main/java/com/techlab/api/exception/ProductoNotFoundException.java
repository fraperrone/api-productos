package com.techlab.api.exception;

public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException(Long id) {
        super("Producton con id:" + id + " no encontrado." );
    }
}
