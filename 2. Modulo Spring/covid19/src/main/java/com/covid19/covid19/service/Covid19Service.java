package com.covid19.covid19.service;

import com.covid19.covid19.dto.PersonaConSintomaDTO;
import com.covid19.covid19.model.Persona;
import com.covid19.covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Covid19Service {
    List<Sintoma> listaSintomas = new ArrayList<>();
    List<Persona> listaPersonas = new ArrayList<>();

    public Covid19Service(){
        Sintoma s1 = new Sintoma(1,"Sintoma1",3);
        Sintoma s2 = new Sintoma(2,"Sintoma2",1);
        Sintoma s3 = new Sintoma(3,"Sintoma3",2);
        listaSintomas.add(s1);
        listaSintomas.add(s2);
        listaSintomas.add(s3);

        Persona p1 = new Persona(1,62,"M","M",new ArrayList<>());
        Persona p2 = new Persona(2,70,"J","J",List.of(s1,s2));
        Persona p3 = new Persona(3,80,"K","K",List.of(s3));
        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
    }

    public List<Sintoma> getSintomasCargados(){
        return listaSintomas;
    }

    public Optional<Sintoma> consultarSintoma(String name){
        return listaSintomas.stream()
                .filter(s -> s.getNombre().equals(name)).findFirst();
    }

    public List<PersonaConSintomaDTO> getPersonasConSintomasMayores(){
        return listaPersonas.stream()
                .filter(p -> p.getEdad()>=60)
                .map(m -> new PersonaConSintomaDTO(m.getNombre(),m.getApellido()))
                .collect(Collectors.toList());
    }
}
