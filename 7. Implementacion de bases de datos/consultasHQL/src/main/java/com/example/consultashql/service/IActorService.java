package com.example.consultashql.service;

import com.example.consultashql.dto.ActorDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> obtenerActoresConPeliculasFavoritas();
}
