package com.techlab.api.usuario;


import com.techlab.api.pedido.Pedido;
import com.techlab.api.pedido.PedidoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    // GET /api/usuarios/{id}/pedidos → lista pedidos de un usuario
    @GetMapping("/{id}/pedidos")
    public List<PedidoResponse> listarPedidosPorUsuario(@PathVariable Long id) {
        return usuarioService.listarPedidosPorUsuario(id);
    }

    // hacemos el loging
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUsuario(@RequestBody LoginRequest request){
        Usuario usuario = usuarioService.login(request.getEmail(), request.getPassword());
        if(usuario == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(new LoginResponse(usuario.getId(), usuario.getEmail(), usuario.getRol()));
    }
}

