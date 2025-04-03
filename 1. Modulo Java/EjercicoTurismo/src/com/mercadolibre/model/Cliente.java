package com.mercadolibre.model;

import java.util.LinkedList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private LinkedList<Localizador> localizadores = new LinkedList<>();
    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LinkedList<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(LinkedList<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void agregarLocalizador(Localizador l){
        this.localizadores.add(l);
    }
}
