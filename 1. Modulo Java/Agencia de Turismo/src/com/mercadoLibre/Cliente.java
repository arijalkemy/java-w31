package com.mercadoLibre;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Localizador> localizadores;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public int getNumeroLocalizadores() {
        return localizadores.size();
    }
}
