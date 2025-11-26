package com.techlab.api.pedido;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoResponse {
    private Long id;
    private Long usuarioId;
    private String estado;
    private LocalDateTime fechaCreacion;
    private List<PedidoProductoResponse> productos;

    // getters y setters
}

