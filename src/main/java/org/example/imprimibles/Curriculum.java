package org.example.imprimibles;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible {
    private final String nombre;
    private final String apellido;
    private final List<String> trabajos;
    private final List<String> habilidades;

    public Curriculum(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.trabajos = new ArrayList<>();
        this.habilidades = new ArrayList<>();
    }

    public void agregarTrabajo(String trabajo) {
        this.trabajos.add(trabajo);
    }

    public void agregarHabilidad(String habilidad) {
        this.habilidades.add(habilidad);
    }

    public void imprimir() {
        System.out.println(nombre + " " + apellido + "\n" + "Experiencia laboral: " + trabajos + "\n" + "Skills: " + habilidades);
    }

}
