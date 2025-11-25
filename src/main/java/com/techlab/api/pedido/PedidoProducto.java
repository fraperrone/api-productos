package com.techlab.api.pedido;


import com.techlab.api.producto.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pedido_productos")
@Data
public class PedidoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

    public PedidoProducto() {}

    public PedidoProducto(Pedido pedido, Producto producto, Integer cantidad) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // getters y setters
}

