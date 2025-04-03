package org.agencia_turismo.domain;

import java.util.List;

public class Localizador {
    private int id;
    private Reserva reserva;

    public Localizador() {
    }

    public Localizador(int id, Reserva reserva) {
        this.id = id;
        this.reserva = reserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
