package com.example.consultashql.service;

import com.example.consultashql.dto.ActorDTO;
import com.example.consultashql.repository.IActorRespository;
import com.example.consultashql.repository.IMovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{

    @Autowired
    private IActorRespository actorRespo;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<ActorDTO> obtenerActoresConPeliculasFavoritas() {
        mapper.registerModule(new JavaTimeModule());
        return actorRespo.findActorBySomeFavoriteMovie().stream()
                .map(a -> mapper.convertValue(a, ActorDTO.class))
                .toList();
    }
}
