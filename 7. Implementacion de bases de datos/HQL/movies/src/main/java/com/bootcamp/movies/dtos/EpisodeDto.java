package com.bootcamp.movies.dtos;

import java.io.Serializable;
import java.util.Date;

import com.bootcamp.movies.model.Episode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EpisodeDto implements Serializable {
    private Integer id;
    private String title;
    private Integer number;
    private Date releaseDate;
    private Double rating;
    private Integer seasonId;

    public static EpisodeDto fromEntity(Episode episode) {
        if (episode == null) {
            return null;
        }

        EpisodeDto dto = new EpisodeDto();
        dto.setId(episode.getId());
        dto.setTitle(episode.getTitle());
        dto.setNumber(episode.getNumber());
        dto.setReleaseDate(episode.getReleaseDate());
        dto.setRating(episode.getRating());

        if (episode.getSeason() != null) {
            dto.setSeasonId(episode.getSeason().getId());
        }

        return dto;
    }
}