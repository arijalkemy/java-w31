package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISerieRepository extends CrudRepository<Serie, Long> {
    @Query("SELECT s FROM Serie s JOIN s.seasons season GROUP BY s HAVING COUNT(season) > :cantidad")
    List<Serie> findSeriesWithMoreThanXSeasons(@Param("cantidad") Long cantidad);
}
