package com.example.elastic.repository;

import com.example.elastic.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, Integer> {

    @Query("{\"bool\": {\"must\": [" +
            "{\"match\": {\"nombre\": \"?0\"}}," +
            "{\"match\": {\"editorial\": \"?1\"}}" +
            "], \"filter\": {\"range\": {\"anioPublicacion\": {\"lt\": \"?2\"}}}}}")
    List<ObraLiteraria> buscarPorNombreYEditorialAntesDe(String nombre, String editorial, int anio);


    List<ObraLiteraria> findAll();
    List<ObraLiteraria> findByAuthorContainingIgnoreCase(String author);

    List<ObraLiteraria> findByNameContainingIgnoreCase(String name);

    List<ObraLiteraria> findByYearPublicationLessThan(Integer year);

    List<ObraLiteraria> findByEditorialIgnoreCase(String editorial);

}
