package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Localizador> localizadores;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public int cantidadDeLocalizadores(){
        return localizadores.size();
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public long contarReservas(String tipo){
        return localizadores.stream()
                .flatMap(l->l.getReservas().stream())
                .filter(l -> l.getTipo().equalsIgnoreCase(tipo))
                .count();
    }
}
