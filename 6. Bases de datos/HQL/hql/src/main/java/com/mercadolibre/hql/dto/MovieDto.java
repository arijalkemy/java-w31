package com.mercadolibre.hql.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    Integer genre_id;
}
