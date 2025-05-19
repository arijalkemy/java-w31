package com.mercadolibre.hql.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class SeasonDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String title;
    Integer number;
    LocalDateTime releaseDate;
    LocalDateTime endDate;
    Integer serie_id;
}
