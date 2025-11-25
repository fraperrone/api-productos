package com.techlab.api;

import com.techlab.api.producto.Producto;
import com.techlab.api.producto.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductoRepository productoRepository;

    @BeforeEach
    void setup() {
        productoRepository.deleteAll();
        productoRepository.save(new Producto(null, "Laptop", "Electrónica", "Laptop gamer", 1500.0, 10, "http://imagen.com/laptop.png"));
        productoRepository.save(new Producto(null, "Mouse", "Accesorios", "Mouse inalámbrico", 25.0, 50, "http://imagen.com/mouse.png"));
    }

    @Test
    void listarProductosDevuelve200YLista() throws Exception {
        mockMvc.perform(get("/api/productos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Laptop"))
                .andExpect(jsonPath("$[1].nombre").value("Mouse"));
    }

    @Test
    void obtenerDetallesDevuelve200YProducto() throws Exception {
        Producto producto = productoRepository.save(
                new Producto(null, "Teclado", "Accesorios", "Teclado mecánico", 80.0, 20, "http://imagen.com/teclado.png")
        );

        mockMvc.perform(get("/api/productos/" + producto.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Teclado"))
                .andExpect(jsonPath("$.precio").value(80.0));
    }

    @Test
    void agregarProductoDevuelve200YProducto() throws Exception {
        mockMvc.perform(post("/api/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Monitor\",\"categoria\":\"Electrónica\",\"descripcion\":\"Monitor 24 pulgadas\",\"precio\":200.0,\"stock\":15,\"imagenUrl\":\"http://imagen.com/monitor.png\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Monitor"))
                .andExpect(jsonPath("$.categoria").value("Electrónica"));
    }

    @Test
    void actualizarProductoDevuelve200YProducto() throws Exception {
        Producto producto = productoRepository.save(
                new Producto(null, "Tablet", "Electrónica", "Tablet básica", 300.0, 5, "http://imagen.com/tablet.png")
        );

        mockMvc.perform(put("/api/productos/" + producto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Tablet Pro\",\"categoria\":\"Electrónica\",\"descripcion\":\"Tablet avanzada\",\"precio\":500.0,\"stock\":8,\"imagenUrl\":\"http://imagen.com/tabletpro.png\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Tablet Pro"))
                .andExpect(jsonPath("$.precio").value(500.0));
    }
}