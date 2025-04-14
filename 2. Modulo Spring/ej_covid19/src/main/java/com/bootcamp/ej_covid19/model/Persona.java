package com.bootcamp.ej_covid19.model;
import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<String> sintomas;

    public Persona(int id, String nombre, String apellido, int edad, List<String> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getSintomas() {
        return sintomas;
    }
}
