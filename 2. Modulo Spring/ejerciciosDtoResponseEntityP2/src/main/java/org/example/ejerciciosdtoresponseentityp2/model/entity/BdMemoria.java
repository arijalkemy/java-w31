package org.example.ejerciciosdtoresponseentityp2.model.entity;

import java.util.ArrayList;
import java.util.List;

public class BdMemoria {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public BdMemoria(List<Deporte> deportes, List<Persona> personas) {
        this.deportes = deportes;
        this.personas = personas;
    }

    public BdMemoria(){

    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void addDeporte(Deporte deporte){
        this.deportes.add(deporte);
    }

    public void addPersona(Persona persona){
        this.personas.add(persona);
    }
}
