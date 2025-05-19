package com.bootcamp.ClavesCompuestas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.ClavesCompuestas.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}