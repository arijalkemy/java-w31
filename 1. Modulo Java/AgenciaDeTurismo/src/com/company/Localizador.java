package com.company;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Double totalConDescuento;
    private Cliente c;
    private List<Reserva> reservas = new ArrayList<Reserva>();

    public Localizador( Cliente c, List<Reserva> reservas) {
        this.totalConDescuento = 0D;
        this.c = c;
        this.reservas = reservas;
    }

    public void calcularDescuento(){
        Double subTotal = reservas.stream().mapToDouble(reserva -> reserva.precio()).sum();

        if(reservas.size()>=4){

        }

    }

    public Double getTotalConDescuento() {
        return totalConDescuento;
    }

    public void setTotalConDescuento(Double totalConDescuento) {
        this.totalConDescuento = totalConDescuento;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "totalConDescuento=" + totalConDescuento +
                ", c=" + c +
                ", reservas=" + reservas +
                '}';
    }
}
