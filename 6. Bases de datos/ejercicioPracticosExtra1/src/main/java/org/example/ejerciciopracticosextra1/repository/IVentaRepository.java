package org.example.ejerciciopracticosextra1.repository;
import org.example.ejerciciopracticosextra1.model.Prenda;
import org.example.ejerciciopracticosextra1.model.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IVentaRepository extends CrudRepository<Venta, Long> {

    Venta getVentaByNumero(Long numero);

    void deleteByNumero(Long numero);
}
