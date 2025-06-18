package com.example.consultashql.controller;

import com.example.consultashql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private IActorService actorSer;

    @GetMapping("/hasFavoriteMov")
    public ResponseEntity<?> getActorThatHasFavoriteMovies(){
        return new ResponseEntity<>(actorSer.obtenerActoresConPeliculasFavoritas(), HttpStatus.OK);
    }
}