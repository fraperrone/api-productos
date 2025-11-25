package com.techlab.api.configuration;

import com.techlab.api.usuario.Usuario;
import com.techlab.api.usuario.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.techlab.api.producto.Producto;
import com.techlab.api.producto.ProductoRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProductoRepository repository) {
        return args -> {
            repository.save(new Producto(null, "Laptop Gamer", "Electrónica", "Laptop potente para gaming", 1500.0, 10, "http://imagen.com/laptop.png"));
            repository.save(new Producto(null, "Mouse Inalámbrico", "Accesorios", "Mouse ergonómico sin cables", 25.0, 50, "http://imagen.com/mouse.png"));
            repository.save(new Producto(null, "Monitor 24\"", "Electrónica", "Monitor Full HD de 24 pulgadas", 200.0, 15, "http://imagen.com/monitor.png"));
        };
    }

    @Bean
    CommandLineRunner initUsuarios(UsuarioRepository usuarioRepository) {
        return args -> {
            usuarioRepository.save(new Usuario("Juan Perez", "juan@mail.com", "1234", "CLIENTE"));
            usuarioRepository.save(new Usuario("Franco Perrone", "franco@mail.com", "adminpass", "ADMIN"));
        };
    }

}

