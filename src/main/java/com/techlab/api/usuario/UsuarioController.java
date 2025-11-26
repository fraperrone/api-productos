package com.techlab.api.usuario;


import com.techlab.api.pedido.Pedido;
import com.techlab.api.pedido.PedidoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // GET /api/usuarios → lista todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // GET /api/usuarios/{id}/pedidos → lista pedidos de un usuario
    @GetMapping("/{id}/pedidos")
    public List<PedidoResponse> listarPedidosPorUsuario(@PathVariable Long id) {
        return usuarioService.listarPedidosPorUsuario(id);
    }
}

