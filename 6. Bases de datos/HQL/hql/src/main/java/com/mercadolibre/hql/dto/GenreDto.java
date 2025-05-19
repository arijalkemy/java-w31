package com.mercadolibre.hql.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter @Setter
public class GenreDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String name;
    Integer ranking;
    Integer active;
}
