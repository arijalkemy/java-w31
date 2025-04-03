package com.mercadolibre.repository;

import com.mercadolibre.model.Localizador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores;

    public RepositorioLocalizador() {
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public void imprimirLocalizadores() {
        if (localizadores.isEmpty()) {
            System.out.println("No hay localizadores almacenados.");
        } else {
            localizadores.forEach(localizador -> {
                System.out.println("Cliente: " + localizador.getCliente().getNombre() +
                        " " + localizador.getCliente().getApellido());
                System.out.println("Total con descuentos: $" + localizador.getTotal());
                System.out.println("-----------------------------");
            });
        }
    }
}
