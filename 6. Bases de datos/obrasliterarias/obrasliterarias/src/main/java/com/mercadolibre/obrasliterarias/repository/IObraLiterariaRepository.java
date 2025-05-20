package com.mercadolibre.obrasliterarias.repository;

import com.mercadolibre.obrasliterarias.domain.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    @Query("""
{
  "match_phrase": {
    "autor": "?0"
  }
}
""")
    List<ObraLiteraria> buscarPorAutor(String autor);

@Query("""
{
  "match_phrase": {
    "nombre": "?0"
  }
}
""")
List<ObraLiteraria> buscarPorNombre(String nombre);
List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
    @Query("""
{
  "range": {
    "anioPrimeraPublicacion": {
      "lt": "?0"
    }
  }
}
""")
    List<ObraLiteraria> findObraLiterariaPublicatedBeforeYear(Integer year);

    @Query("""
{
  "match_phrase": {
    "editorial": "?0"
  }
}
""")
    List<ObraLiteraria> buscarPorEditorial(String editorial);

}