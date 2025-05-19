package com.mercadolibre.movieshql.repository;

import com.mercadolibre.movieshql.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT s FROM Serie s WHERE SIZE(s.seasons) > :minSeasons")
    List<Serie> findSeriesByMinSeasons(@Param("minSeasons") int minSeasons);
}
