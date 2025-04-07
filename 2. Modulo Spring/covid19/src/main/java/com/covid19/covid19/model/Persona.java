package com.covid19.covid19.model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private Integer id,edad;
    private String nombre,apellido;
    private List<Sintoma> listaDeSintomas = new ArrayList<>();


    public Persona(Integer id, Integer edad, String nombre, String apellido, List<Sintoma> listaSintoma) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaDeSintomas = listaSintoma;
    }

    public List<Sintoma> getListaDeSintomas() {
        return listaDeSintomas;
    }

    public void setListaDeSintomas(List<Sintoma> listaDeSintomas) {
        this.listaDeSintomas = listaDeSintomas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
