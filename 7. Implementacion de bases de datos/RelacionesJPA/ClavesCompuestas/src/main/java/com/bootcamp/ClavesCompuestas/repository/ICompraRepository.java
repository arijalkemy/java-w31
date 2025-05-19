package com.bootcamp.ClavesCompuestas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.ClavesCompuestas.model.Compra;
import com.bootcamp.ClavesCompuestas.model.CompraPK;

public interface ICompraRepository extends JpaRepository<Compra, CompraPK> {
}
