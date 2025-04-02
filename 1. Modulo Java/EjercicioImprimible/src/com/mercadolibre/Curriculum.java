package com.mercadolibre;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Curriculum implements Imprimible{

    /* 	Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
     */
    List<String> habilidades = new ArrayList<>();


    Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    public void agregarHabilidad(String habilidad){
        this.habilidades.add(habilidad);
    }

    @Override
    public String imprimir() {
        String habilidades = this.habilidades.stream()
                .map(h -> "- " + h)
                .collect(Collectors.joining("\n"));
        String imprimible = this.persona.getNombre() + ", edad: " + this.persona.getEdad() +
                ". Estudió en: " + this.persona.getEducacion() + ". Vive en: " + this.persona.getLocalidad() +
                ". Contacto: " + this.persona.getTelefono() + "\n" + "Mis habilidades son: " + "\n" + habilidades;
        return imprimible;
    }
}
