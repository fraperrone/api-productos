package com.techlab.api.pedido;


import com.techlab.api.exception.StockInsuficienteException;
import com.techlab.api.producto.Producto;
import com.techlab.api.exception.ProductoNotFoundException;
import com.techlab.api.producto.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoProductoRepository pedidoProductoRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         PedidoProductoRepository pedidoProductoRepository, ProductoRepository productoRepository, ProductoRepository productoRepository1) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoProductoRepository = pedidoProductoRepository;
        this.productoRepository = productoRepository1;
    }

    @Transactional
    public Pedido crearPedido(PedidoRequest request) {
        System.out.println("request (iniciando crearPedido Service) = " + request);

        Pedido pedido = new Pedido(request.getUsuarioId(), "PENDIENTE");
        System.out.println("pedido = " + pedido);

        for (PedidoProductoDTO dto : request.getItemsPedidos()) {
            // Buscar el producto en la DB
            Producto producto = productoRepository.findById(dto.getProductoId())
                    .orElseThrow(() -> new ProductoNotFoundException(dto.getProductoId()));

            // Validar stock
            if (producto.getStock() < dto.getCantidad()) {
                throw new StockInsuficienteException(
                        "Stock insuficiente para el producto: " + producto.getNombre()
                );
            }

            // Descontar stock
            producto.setStock(producto.getStock() - dto.getCantidad());
            productoRepository.save(producto);

            // Crear detalle del pedido con producto asignado
            PedidoProducto pedidoProducto = new PedidoProducto();
            pedidoProducto.setPedido(pedido);
            pedidoProducto.setProducto(producto); // 🔑 acá se asigna el producto
            pedidoProducto.setCantidad(dto.getCantidad());

            pedido.getProductos().add(pedidoProducto);
        }

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
