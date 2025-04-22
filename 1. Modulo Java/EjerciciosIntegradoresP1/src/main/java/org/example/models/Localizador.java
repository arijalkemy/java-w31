package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    Cliente cliente;
    List<Reserva> reservas = new ArrayList<>();

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }
}
