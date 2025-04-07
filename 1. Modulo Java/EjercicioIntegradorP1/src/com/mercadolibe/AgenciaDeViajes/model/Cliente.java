package com.mercadolibe.AgenciaDeViajes.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private int id;
    private List<Localizador> localizadores;

    public Cliente() {
    }

    public Cliente(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.localizadores = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public int getNumeroLocalizadores() {
        return localizadores.size();
    }
}
