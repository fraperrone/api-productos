package com.techlab.api.pedido;

import lombok.Data;

import java.util.List;

@Data
public class PedidoRequest {
    private Long usuarioId;
    private List<PedidoProductoDTO> itemsPedidos;

    // getters y setters
}

