package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.ActorDto;
import com.mercadolibre.hql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    IActorService actorService;
    @GetMapping("/favorite-movie")
    public ResponseEntity<List<ActorDto>> actorsWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.getActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ActorDto>> actorsWithRatingGreaterThan(@PathVariable Double rating) {
        return new ResponseEntity<>(actorService.getActorsWithRatingGreaterThan(rating),HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ActorDto>> actorsByMovie(@PathVariable Long movieId) {
        return new ResponseEntity<>(actorService.getActorsByMovieId(movieId), HttpStatus.OK);
    }
}
