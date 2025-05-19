package com.mercadolibre.hql.dto;

import com.mercadolibre.hql.model.Actor;
import com.mercadolibre.hql.model.ActorMovie;
import com.mercadolibre.hql.model.Genre;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
public class MovieDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String title;
    Double rating;
    Integer awards;
    LocalDateTime releaseDate;
    Integer length;
    private Genre genre;
    private Set<Actor> actors;
    private Set<ActorMovie> actorMovies;
}
