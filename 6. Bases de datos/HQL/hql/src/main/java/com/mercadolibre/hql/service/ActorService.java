package com.mercadolibre.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.hql.dto.ActorDto;
import com.mercadolibre.hql.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{
    @Autowired
    IActorRepository actorRepository;
    @Autowired
    ObjectMapper mapper;
    public List<ActorDto> getActorsWithFavoriteMovie() {
        return actorRepository.findActorsWithFavoriteMovie().stream()
                .map(a -> mapper.convertValue(a, ActorDto.class)).toList();
    }
    public List<ActorDto> getActorsWithRatingGreaterThan(Double rating) {
        return actorRepository.findActorsWithRatingGreaterThan(rating).stream()
                .map(a -> mapper.convertValue(a, ActorDto.class)).toList();
    }

    public List<ActorDto> getActorsByMovieId(Long movieId) {
        return actorRepository.findActorsByMovieId(movieId).stream()
                .map(a -> mapper.convertValue(a, ActorDto.class)).toList();
    }
}
