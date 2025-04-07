package com.mercadolibre.ejerciciodto.service;

import com.mercadolibre.ejerciciodto.entidades.Deporte;
import com.mercadolibre.ejerciciodto.entidades.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EncontrarDeporteService {
    /* Ver todos los deportes que tenemos cargados.*/
    private List<Deporte> deportes = new ArrayList<>();
    private List<PersonaDTO> personasdeportistas = new ArrayList<>();

    public EncontrarDeporteService() {
        deportes.add(new Deporte("Fútbol", 3));
        deportes.add(new Deporte("Básquet", 2));
        deportes.add(new Deporte("Tenis", 4));

        personasdeportistas.add(new PersonaDTO("Ornella", "Alonso", deportes.get(0)));
        personasdeportistas.add(new PersonaDTO("Micaela", "Francese", deportes.get(2)));
        personasdeportistas.add(new PersonaDTO("Marianela", "Alonso", deportes.get(1)));
        personasdeportistas.add(new PersonaDTO("Sharon", "Breyani", deportes.get(0)));
    }


    public List<Deporte> getListaDeporte(){
        return this.deportes;
    }

    /*Consultar si existe un deporte ingresando su nombre.
    De existir, se deberá mostrar el nivel del mismo.
    Utilizar la clase ResponseEntity para devolver la respuesta.*/
    public String getNivelDelDeporte(String nombre){
        Deporte deporte = this.deportes.stream().filter(d -> d.getNombre().equals(nombre))
                            .findFirst().orElse(null);
        return "El nivel del deporte " + nombre + " es: " + deporte.getNivel();
    }


    /* Visualizar a las personas deportistas. Queremos que se vea un
     listado con el nombre y el apellido de la persona y el nombre del
     deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado).
     Para este punto es importante valerse de un DTO.
       PATH: /findSportsPersons*/
    public List<String> getPersonasDeportistas(){
        return this.personasdeportistas.stream()
                .map(pd -> "- " + pd.getNombre() + " " + pd.getApellido() + " realiza el deporte: " + pd.getDeporte().getNombre())
                .collect(Collectors.toList());
    }

}
