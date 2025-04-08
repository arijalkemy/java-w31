package org.ejercicios.covid19.repository;

import org.ejercicios.covid19.model.Persona;
import org.ejercicios.covid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CovidRepository {
    private List<Sintoma> sintomasList = new ArrayList<>();
    private List<Persona> personaList = new ArrayList<>();

    public CovidRepository () {
    }

    public List<Sintoma> getAllSintomas() {
        return sintomasList;
    }

    public Sintoma getSintomaByCodigo(String codigo) {
        Optional<Sintoma> sintoma = sintomasList.stream().filter(s -> s.getCodigo().equals(codigo)).findFirst();
        if (sintoma.isPresent()) {
            return sintoma.get();
        } else {
            throw new IllegalArgumentException("El codigo buscado no existe");
        }
    }

    public List<Persona> getAllPersonas() {
        return personaList;
    }

}
