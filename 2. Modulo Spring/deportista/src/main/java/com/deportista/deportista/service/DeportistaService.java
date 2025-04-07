package com.deportista.deportista.service;

import com.deportista.deportista.dto.PersonaDeportistaDTO;
import com.deportista.deportista.model.Deporte;
import com.deportista.deportista.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeportistaService {
    private List<Deporte> listaDeportes = new ArrayList<>();
    private List<Persona> listaPersonas = new ArrayList<>();

    public DeportistaService(){
        Deporte d1 = new Deporte("Futbol",1);
        Deporte d2 = new Deporte("Tenis",2);
        Deporte d3 = new Deporte("Padel",3);
        Deporte d4 = new Deporte("Basket",2);

        listaDeportes.add(d1);
        listaDeportes.add(d2);
        listaDeportes.add(d3);
        listaDeportes.add(d4);

        Persona p1 = new Persona("Miguel","Bustos",30,new ArrayList<>());
        Persona p2 = new Persona("Jose","Perez",35, List.of(d1,d2));
        Persona p3 = new Persona("Melisa","Vargas",27, List.of(d3));
        Persona p4 = new Persona("Ludmila","Lucero",25,List.of(d4));

        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);
    }

    public List<Deporte> getListaDeportes() {
        return listaDeportes;
    }

    public Optional<Deporte> buscarDeportePorNombre(String nombre){
        return listaDeportes.stream()
                .filter(d -> d.getNombre().equals(nombre))
                .findFirst();
    }

    public List<PersonaDeportistaDTO> verPersonasDeportistas(){
        return listaPersonas.stream()
                .map(d -> new PersonaDeportistaDTO(d.getNombre(),
                        d.getApellido(),
                        d.getListaDeporte()
                                .stream()
                                .map(Deporte::getNombre)
                                .collect(Collectors.joining(", "))))
                .collect(Collectors.toList());
    }
}
