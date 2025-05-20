package com.bootcamp.movies.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.bootcamp.movies.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto implements Serializable {
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private Date releaseDate;
    private Integer length;
    private Integer genreId;
    private List<Integer> favoredByIds;

    public static MovieDto fromEntity(com.bootcamp.movies.model.Movie movie) {
        if (movie == null) {
            return null;
        }

        MovieDto dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setRating(movie.getRating());
        dto.setAwards(movie.getAwards());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setLength(movie.getLength());

        if (movie.getGenre() != null) {
            dto.setGenreId(movie.getGenre().getId());
        }

        if (movie.getFavoredBy() != null) {
            List<Integer> actorIds = movie.getFavoredBy()
                    .stream()
                    .map(Actor::getId)
                    .toList();
            dto.setFavoredByIds(actorIds);
        }

        return dto;
    }
}