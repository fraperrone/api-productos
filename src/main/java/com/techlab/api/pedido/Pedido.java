package com.techlab.api.pedido;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Usuario (por ahora solo guardamos el id)
    @Column(nullable = false)
    private Long usuarioId;

    // Relación con los productos del pedido
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoProducto> productos = new ArrayList<>();

    // Estado del pedido (ejemplo: PENDIENTE, CONFIRMADO, ENTREGADO)
    private String estado;

    // Fecha de creación
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Constructor vacío requerido por JPA
    public Pedido() {}

    // Constructor con parámetros
    public Pedido(Long usuarioId, String estado) {
        this.usuarioId = usuarioId;
        this.estado = estado;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public List<PedidoProducto> getProductos() { return productos; }
    public void setProductos(List<PedidoProducto> productos) { this.productos = productos; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}