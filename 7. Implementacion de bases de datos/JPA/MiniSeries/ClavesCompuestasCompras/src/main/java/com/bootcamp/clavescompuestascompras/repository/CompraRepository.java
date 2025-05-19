package com.bootcamp.clavescompuestascompras.repository;

import com.bootcamp.clavescompuestascompras.entity.Compra;
import com.bootcamp.clavescompuestascompras.entity.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
