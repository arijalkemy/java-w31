package com.mercadolibre.hql.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ActorDto {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String firstName;
    String lastName;
    Double rating;
    Integer favoriteMovieId;
}
