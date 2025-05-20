package com.mercadolibre.elasticsearch2.repository;

import com.mercadolibre.elasticsearch2.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, Long> {
    List<ObraLiteraria> findAllByAutor(String autor);
    List<ObraLiteraria> findAllByNombreContains(String nombre);
    List<ObraLiteraria> findAllByEditorial(String editorial);
    List<ObraLiteraria> findTop5ByOrderByCantidadDePaginasDesc();
    List<ObraLiteraria> findAllByAñoPublicacionBefore(Integer anio);
}
