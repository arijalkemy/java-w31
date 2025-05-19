package com.bootcamp.ClavesCompuestas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.ClavesCompuestas.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}