package com.mercadolibre.agenciaDeViajes.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private List<Localizador> localizadores;

    public Cliente(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.localizadores = new ArrayList<Localizador>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    public int getCantidadLocalizadores() {
        return localizadores.size();
    }
}
