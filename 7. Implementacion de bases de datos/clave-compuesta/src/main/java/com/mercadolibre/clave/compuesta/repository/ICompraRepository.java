package com.mercadolibre.clave.compuesta.repository;

import com.mercadolibre.clave.compuesta.entity.CompraClienteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<CompraClienteId, Integer> {

}
