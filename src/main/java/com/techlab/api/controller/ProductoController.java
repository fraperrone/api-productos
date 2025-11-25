package com.techlab.api.controller;

import com.techlab.api.model.Producto;
import com.techlab.api.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {


    private final ProductoService productoService;


    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos(){
        return productoService.listarProductosDisponibles();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerDetalles(@PathVariable long id){
        return productoService.obtenerDeatallesProducto(id);
    }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto){
        return productoService.agregarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable long id, @RequestBody Producto producto){
        producto.setId(id);
        return productoService.actualizarProducto(producto);
    }

}
