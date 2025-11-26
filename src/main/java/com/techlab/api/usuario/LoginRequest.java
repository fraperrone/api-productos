package com.techlab.api.usuario;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    // getters y setters
}

