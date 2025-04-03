package com.mercadolimbre.modulojava.agenciadeturismo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Localizador> baseDatos = new ArrayList<Localizador>();

    public RepositorioCliente() {
    }

    public  void agregarLocalizador(Localizador localizador) {
        baseDatos.add(localizador);
    }

    public List<Localizador> obtenerLocalizadores(Cliente cliente) {
        return baseDatos.stream().filter(x -> x.getCliente().equals(cliente)).toList();
    }
}
