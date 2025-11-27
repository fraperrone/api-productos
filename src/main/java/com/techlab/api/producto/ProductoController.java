package com.techlab.api.producto;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Producto> obtenerDetalles(@PathVariable long id) {
        return productoService.obtenerDeatallesProducto(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ProductoNotFoundException(id));
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
