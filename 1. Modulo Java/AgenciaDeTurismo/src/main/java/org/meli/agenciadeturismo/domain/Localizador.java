package org.meli.agenciadeturismo.domain;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private int id;
    private List<Reserva> reservaList;

    public Localizador() {
        reservaList = new ArrayList<>();
    }

    public Localizador(int id, List<Reserva> reservaList) {
        this.id = id;
        this.reservaList = reservaList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", reservaList=" + reservaList +
                '}';
    }
}
