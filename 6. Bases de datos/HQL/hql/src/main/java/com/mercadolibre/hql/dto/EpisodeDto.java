package com.mercadolibre.hql.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    Integer seasonId;
}
