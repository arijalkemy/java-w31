package org.example.hqlmoviesejercicio1.repository;

import org.example.hqlmoviesejercicio1.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends CrudRepository<Serie,Integer> {

    @Query("select s from Serie s join s.seasons sea where sea.number>:season")
    List<Serie> findSerieWithMinimumSeason(@Param("season") Integer season);
}
