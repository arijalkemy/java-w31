package com.mercadolibre.hql.dto;


import com.mercadolibre.hql.model.Movie;
import com.mercadolibre.hql.model.Serie;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
public class GenreDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String name;
    Integer ranking;
    Integer active;
    private Set<Serie> series;
    private Set<Movie> movies;
}
