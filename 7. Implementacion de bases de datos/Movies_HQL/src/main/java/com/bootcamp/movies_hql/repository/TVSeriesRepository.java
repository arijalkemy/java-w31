package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.model.TVSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TVSeriesRepository extends JpaRepository<HttpStatus.Series, Long> {

    @Query("SELECT s FROM Series s WHERE s.numberOfSeasons > :number")
    List<TVSeries> getSeriesByNumberOfSeasons(int number);
}

