package com.techlab.api;

import com.techlab.api.producto.ProductoController;
import com.techlab.api.producto.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductoController.class)
class ProductoControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Test
    void listarProductosDevuelve200() throws Exception {
        // Simulamos que el servicio devuelve una lista

        mockMvc.perform(get("/api/productos"))
                .andExpect(status().isOk());
    }
}


