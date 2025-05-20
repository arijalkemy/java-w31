package com.bootcamp.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.movies.model.Serie;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {
    @Query("SELECT s FROM Serie s WHERE SIZE(s.seasons) > :minSeasons")
    List<Serie> findSeriesByMinSeasons(@Param("minSeasons") int minSeasons);
}
