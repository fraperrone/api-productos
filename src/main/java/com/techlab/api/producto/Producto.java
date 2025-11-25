package com.techlab.api.producto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String categoria;

    @Column(length = 1000)
    private String descripcion;

    private Double precio;

    private Integer stock;

    @Column(name = "imagen_url")
    private String imagenUrl;
}
