package org.example.hqlmoviesejercicio1.controller;
import org.example.hqlmoviesejercicio1.model.Actor;
import org.example.hqlmoviesejercicio1.service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class ActorController {


    private final ActorServiceImpl actorService;

    @Autowired
    public ActorController(ActorServiceImpl actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/findActorWithFavoriteMovie")
    public ResponseEntity<List<Actor>> findActorWithFavoriteMovie(){
        return new ResponseEntity<>(this.actorService.findActorWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/findActorWithMinimumRating/{rating}")
    public ResponseEntity<List<Actor>> findActorWithMinimumRating(@PathVariable BigDecimal rating){
        return new ResponseEntity<>(this.actorService.findActorWithMinimumRating(rating), HttpStatus.OK);
    }

    @GetMapping("/findActorWorkInTheMovie/{movie}")
    public ResponseEntity<List<Actor>> findActorWorkInTheMovie(@PathVariable String movie){
        return new ResponseEntity<>(this.actorService.findActorWorkInTheMovie(movie), HttpStatus.OK);
    }
}
