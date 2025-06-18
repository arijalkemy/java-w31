package com.example.consultashql.dto;

import com.example.consultashql.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ActorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;
    private Long favoriteMovieId;
    private Set<Long> movieIds;
    private Set<Long> episodeIds;
}