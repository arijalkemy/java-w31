package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.ActorDto;

import java.util.List;

public interface IActorService {
    public List<ActorDto> getActorsWithFavoriteMovie();
    public List<ActorDto> getActorsWithRatingGreaterThan(Double rating);
    public List<ActorDto> getActorsByMovieId(Long movieId);
}
