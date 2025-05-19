package org.mercadolibre.ejercicio_hql.controller;

import org.mercadolibre.ejercicio_hql.dto.ActorDTO;
import org.mercadolibre.ejercicio_hql.entities.Actor;
import org.mercadolibre.ejercicio_hql.service.ActorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/actors")
public class ActorController {
    final private ActorServiceImpl service;

    public ActorController(ActorServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/favorite_movie")
    public List<ActorDTO>  getActorsWithFavoriteMovie(){
        return service.findActorsWithFavoriteMovie();
    }
}
