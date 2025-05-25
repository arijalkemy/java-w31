package com.mercadolibre.obrasliterariases.repository;

import com.mercadolibre.obrasliterariases.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByNombreContainingIgnoreCase(String palabraClave);
    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
    List<ObraLiteraria> findByAnioPublicacionLessThan(int anio);
    List<ObraLiteraria> findByEditorial(String editorial);
}