package com.mercadolibre.hql.dto;

import com.mercadolibre.hql.model.Genre;
import com.mercadolibre.hql.model.Season;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
public class SerieDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String title;
    LocalDateTime releaseDate;
    LocalDateTime endDate;
    private Genre genre;
    private Set<Season> seasons;
}
