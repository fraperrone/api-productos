package com.techlab.api.repository;

import com.techlab.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository <Producto, Long>{
}
