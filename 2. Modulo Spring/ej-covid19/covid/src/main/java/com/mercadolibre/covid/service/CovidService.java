package com.mercadolibre.covid.service;

import com.mercadolibre.covid.BaseDeDatos;
import com.mercadolibre.covid.dto.PersonaEnRiesgoDto;
import com.mercadolibre.covid.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CovidService {

    public static String findSymptom() {
        String sintomas = "";

        for (Sintoma s : BaseDeDatos.sintomas) {
            sintomas += "\n";
            sintomas += s.toString();
        }

        return sintomas;
    }

    public static ResponseEntity findSpecificSymptom(@PathVariable String symptom) {
        Optional<Sintoma> sintoma = Arrays.stream(BaseDeDatos.sintomas).filter(s -> s.getNombre().equals(symptom)).findFirst();
        if (sintoma.isPresent()) {
            return new ResponseEntity(sintoma.get().toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity("No se encontro ese sintoma", HttpStatus.NOT_FOUND);
        }
    }

    public static Stream<PersonaEnRiesgoDto> findRiskPerson() {
        return Arrays.stream(BaseDeDatos.personas_en_riesgo).map(per -> per.toDto());
    }
}
