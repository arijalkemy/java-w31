package com.bootcamp.movies.dtos;

import java.io.Serializable;

import com.bootcamp.movies.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActorDto implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;

    public static ActorDto fromEntity(Actor actor) {
        if (actor == null) {
            return null;
        }

        ActorDto dto = new ActorDto();
        dto.setId(actor.getId());
        dto.setFirstName(actor.getFirstName());
        dto.setLastName(actor.getLastName());
        dto.setRating(actor.getRating());

        if (actor.getFavoriteMovie() != null) {
            dto.setFavoriteMovieId(actor.getFavoriteMovie().getId());
        }

        return dto;
    }
}