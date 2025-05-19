package com.mercadolibre.hql.dto;

import com.mercadolibre.hql.model.Episode;
import com.mercadolibre.hql.model.Serie;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
public class SeasonDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String title;
    Integer number;
    LocalDateTime releaseDate;
    LocalDateTime endDate;
    private Serie serie;
    private Set<Episode> episodes;
}
