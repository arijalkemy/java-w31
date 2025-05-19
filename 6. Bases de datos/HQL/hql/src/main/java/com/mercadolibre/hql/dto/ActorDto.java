package com.mercadolibre.hql.dto;


import com.mercadolibre.hql.model.ActorEpisode;
import com.mercadolibre.hql.model.ActorMovie;
import com.mercadolibre.hql.model.Movie;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class ActorDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String firstName;
    String lastName;
    Double rating;
    Movie movie;
    private Set<ActorEpisode> actorsEpisodes;
    private Set<ActorMovie> actorMovies;
}
