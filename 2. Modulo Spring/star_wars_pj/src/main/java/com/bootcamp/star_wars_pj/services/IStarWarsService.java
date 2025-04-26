package com.bootcamp.star_wars_pj.services;

import com.bootcamp.star_wars_pj.dtos.ConsultaPersonajeDTO;

import java.util.List;

public interface IStarWarsService {
    List<ConsultaPersonajeDTO> searchPersonajes(String query);
}
