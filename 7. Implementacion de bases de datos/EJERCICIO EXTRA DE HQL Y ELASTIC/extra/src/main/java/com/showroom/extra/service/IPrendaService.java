package com.showroom.extra.service;

import com.showroom.extra.dto.PrendaDTO;
import com.showroom.extra.model.Prenda;

import java.util.List;
import java.util.Optional;

public interface IPrendaService {
    //Crear una nueva prenda.
    Prenda save(PrendaDTO prendaDTO);

    //Devolver todas las prendas
    List<Prenda> findAll();

    //Devolver una prenda en particular
    Optional<Prenda> findById(Long codigo);

    //Actualizar una prenda en particular
    Prenda updatePrenda(Long codigo,PrendaDTO prendaDTO);

    //Eliminar una prenda en particular
    String delete(Long codigo);

    //Traer todas las prendas de un determinado talle
    List<Prenda> findByTalle(String talle);

    //Buscar todas las prendas en cuyo nombre aparezca la palabra “remera”.
    // No se tienen en cuenta ni mayúsculas ni minúsculas
    List<Prenda> findByRemera(String tipo);

}
