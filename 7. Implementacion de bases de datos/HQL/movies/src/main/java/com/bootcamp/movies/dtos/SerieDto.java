package com.bootcamp.movies.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.bootcamp.movies.model.Season;
import com.bootcamp.movies.model.Serie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SerieDto implements Serializable {
    private Integer id;
    private String title;
    private Date releaseDate;
    private Date endDate;
    private Integer genreId;
    private List<Integer> seasonIds;

    public static SerieDto fromEntity(Serie serie) {
        if (serie == null) {
            return null;
        }
        SerieDto dto = new SerieDto();
        dto.setId(serie.getId());
        dto.setTitle(serie.getTitle());
        dto.setReleaseDate(serie.getReleaseDate());
        dto.setEndDate(serie.getEndDate());

        if (serie.getGenre() != null) {
            dto.setGenreId(serie.getGenre().getId());
        }

        if (serie.getSeasons() != null) {
            List<Integer> seasonIds = serie.getSeasons()
                    .stream()
                    .map(Season::getId)
                    .toList();
            dto.setSeasonIds(seasonIds);
        }

        return dto;
    }
}