package com.techlab.api.pedido;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Spring Data JPA genera el query automáticamente:
    // SELECT * FROM pedidos WHERE usuario_id = :usuarioId
    List<Pedido> findByUsuarioId(Long usuarioId);

}
