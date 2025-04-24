package com.fernandotorres.multicapa.service;

import com.fernandotorres.multicapa.dto.PersonajeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonajesService {

    public List<PersonajeDTO> getPersonaje(String name);

}
