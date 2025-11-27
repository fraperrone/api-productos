package com.techlab.api.exception;

import com.techlab.api.producto.ProductoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //  esta clase intercepta excepciones en todos los controladores
public class GlobalExceptionHandler {



    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductoNotFound(ProductoNotFoundException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", 404);
        error.put("error", "Not Found");
        error.put("message", ex.getMessage());
        error.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
