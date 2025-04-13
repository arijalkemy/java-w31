package com.example.deportistas.service;

import com.example.deportistas.BaseDeDatos;
import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DeportistasService {
    public static String findSports() {
        String deportes = "";
        for (Deporte d : BaseDeDatos.deportes) {
            deportes += System.lineSeparator();
            deportes += d.toString();
        }
        return deportes;
    };

    public static ResponseEntity findSpecificSport (String sport) {
        Optional<Deporte> deporte = Arrays.stream(BaseDeDatos.deportes).filter(d -> d.getNombre().equals(sport)).findFirst();

        if (deporte.isPresent()) {
            return new ResponseEntity<>(deporte.get().toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe tal deporte.", HttpStatus.NOT_FOUND);
        }
    }

    public static Stream<DeportistaDto> findSportsPersons () {
        Stream<DeportistaDto> dtos = Arrays.stream(BaseDeDatos.deportistas).map(d -> new DeportistaDto(d.getNombre(), d.getApellido(), d.getDeporte().getNombre()));

        return dtos;
    };
}
