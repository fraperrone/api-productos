package com.techlab.api.usuario;

import com.techlab.api.pedido.Pedido;
import com.techlab.api.pedido.PedidoProductoResponse;
import com.techlab.api.pedido.PedidoRepository;
import com.techlab.api.pedido.PedidoResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PedidoRepository pedidoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.pedidoRepository = pedidoRepository;
    }

    // Crear usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar usuario por ID
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    // Buscar usuario por email
    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
    }

    // Eliminar usuario
    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    //listar pedido por usuario
    // Listar pedidos de un usuario por id
    public List<PedidoResponse> listarPedidosPorUsuario(Long usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new RuntimeException("Usuario no encontrado con id: " + usuarioId);
        }

        List<Pedido> pedidos = pedidoRepository.findByUsuarioId(usuarioId);

        // Convertimos cada Pedido a PedidoResponse
        return pedidos.stream().map(p -> {
            PedidoResponse dto = new PedidoResponse();
            dto.setId(p.getId());
            dto.setUsuarioId(p.getUsuarioId());
            dto.setEstado(p.getEstado());
            dto.setFechaCreacion(p.getFechaCreacion());

            List<PedidoProductoResponse> productosDto = p.getProductos().stream().map(pp -> {
                PedidoProductoResponse ppDto = new PedidoProductoResponse();
                ppDto.setProductoId(pp.getProducto().getId());
                ppDto.setNombreProducto(pp.getProducto().getNombre());
                ppDto.setCantidad(pp.getCantidad());
                return ppDto;
            }).toList();

            dto.setProductos(productosDto);
            return dto;
        }).toList();
    }



}