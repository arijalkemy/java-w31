package org.example.ejerciciopracticosextra1.service;

import org.example.ejerciciopracticosextra1.model.Prenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IPrendaService {
    List<Prenda> getAllPrendas();
    Prenda getPrendaByCodigo(String codigo);
    List<Prenda> getPrendaByTalla(Prenda.Talla talla);
    List<Prenda> getPrendaByNombre(String nombre);
    void createPrenda(Prenda prenda);
    void updatePrenda(String codigo, Prenda prenda);
    void deletePrenda(String codigo);
}
