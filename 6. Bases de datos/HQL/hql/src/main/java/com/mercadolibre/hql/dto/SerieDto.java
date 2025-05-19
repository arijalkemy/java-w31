package com.mercadolibre.hql.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class SerieDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String title;
    LocalDateTime releaseDate;
    LocalDateTime endDate;
    Integer genre_id;
}
