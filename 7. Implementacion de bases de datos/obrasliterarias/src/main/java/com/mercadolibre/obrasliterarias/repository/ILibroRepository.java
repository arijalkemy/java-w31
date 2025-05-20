package com.mercadolibre.obrasliterarias.repository;

import com.mercadolibre.obrasliterarias.domain.Libro;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILibroRepository extends ElasticsearchRepository<Libro,String> {

    List<Libro> findLibroByAutor(String autor);
    @Query("{\n" +
            "  \"bool\": {\n" +
            "    \"must\": [\n" +
            "      {\n" +
            "        \"match\": {\n" +
            "          \"nombre\": \"?0\"\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}")
    List<Libro> findByNombre(String nombre);

    @Query("{\n" +
            "  \"bool\": {\n" +
            "    \"must\": [\n" +
            "      {\n" +
            "        \"range\": {\n" +
            "          \"año\": { \"gte\": \"?0\" }\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}")
    List<Libro> findByYear(Long year);

    List<Libro> findLibroByEditorial(String editorial);

    List<Libro> findTop5ByOrderByCantidadPaginasDesc();


}
