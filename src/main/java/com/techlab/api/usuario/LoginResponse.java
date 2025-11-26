package com.techlab.api.usuario;

import lombok.Data;

@Data
public class LoginResponse {
    private Long id;
    private String email;
    private String rol;

    public LoginResponse(Long id, String email, String rol) {
        this.id = id;
        this.email = email;
        this.rol = rol;
    }

    // getters
}

