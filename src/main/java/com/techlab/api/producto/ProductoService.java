package com.techlab.api.producto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    @Override
    public List<Producto> listarProductosDisponibles() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerDeatallesProducto(long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(long id) {
        productoRepository.deleteById(id);
    }
}
