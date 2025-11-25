package com.techlab.api.producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {



    //listar productos
    List<Producto>listarProductosDisponibles();

    //obtener dealles
    Optional<Producto> obtenerDeatallesProducto(long id);

    //agregar nuevos productos
    Producto agregarProducto(Producto producto);

    //actualizar informacion
    Producto actualizarProducto(Producto producto);

    //eliminar producto
    void eliminarProducto(long id);
}
