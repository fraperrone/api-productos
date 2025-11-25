package com.techlab.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Spring Data JPA genera la query automáticamente
    Optional<Usuario> findByEmail(String email);
}
