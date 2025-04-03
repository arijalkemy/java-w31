package com.company;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Localizador> listaLocalizador;

    public RepositorioCliente() {
        listaLocalizador = new ArrayList<>();

    }
    public void agregarLocalizador(Localizador l){
        listaLocalizador.add(l);
    }

    public List<Localizador> getLocalizador() {
        return listaLocalizador;
    }

    public void setLocalizador(List<Localizador> localizador) {
        this.listaLocalizador = localizador;
    }

    public void mostrarInfo() {
        listaLocalizador.forEach(l -> System.out.println(l.getC().toString()));
        listaLocalizador.forEach(l-> System.out.println(l.getReservas().toString()));
    }

    public Integer consultarCantidadLocalizador (Cliente c){
        return (int) listaLocalizador.stream().filter(l-> l.getC().equals(c)).count();
    }


}
