package com.mercadolibre.hql.dto;

import com.mercadolibre.hql.model.ActorEpisode;
import com.mercadolibre.hql.model.Season;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class EpisodeDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String title;
    Integer number;
    LocalDateTime releaseDate;
    Double rating;
    private Season season;
    private Set<ActorEpisode> actors_episodes;
}
