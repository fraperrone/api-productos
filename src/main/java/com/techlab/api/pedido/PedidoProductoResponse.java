package com.techlab.api.pedido;


import lombok.Data;

@Data
public class PedidoProductoResponse {
    private Long productoId;
    private String nombreProducto;
    private int cantidad;

    // getters y setters
}

