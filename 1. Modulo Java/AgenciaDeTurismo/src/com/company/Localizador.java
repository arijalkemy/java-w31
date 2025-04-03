package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Localizador {
    private Double totalConDescuento;
    private Cliente c;
    private List<Reserva> reservas = new ArrayList<Reserva>();

    public Localizador( Cliente c, List<Reserva> reservas) {
        this.totalConDescuento = 0D;
        this.c = c;
        this.reservas = reservas;
    }

    public void calcularDescuento(Cliente c){
        this.totalConDescuento = reservas.stream().mapToDouble(r -> r.precio()).sum();

        if(c.getDescuentox2Localizadores())
        {
            this.totalConDescuento = this.totalConDescuento * 0.95;
        }else if (reservas.stream()
                .map(Reserva::getClass) // Obtiene la clase de cada reserva
                .collect(Collectors.toSet()) // Convierte en un conjunto de clases únicas
                .containsAll(Set.of(ReservaHotel.class, ReservaComida.class, ReservaTransporte.class, ReservaBoleto.class))){

            this.totalConDescuento = this.totalConDescuento * .90;
        }else{

            long countHotel = reservas.stream().filter(r -> r instanceof ReservaHotel).count();
            long countBoleto = reservas.stream().filter(r -> r instanceof ReservaBoleto).count();

            if (countHotel >= 2 || countBoleto >= 2) {
                this.totalConDescuento -= reservas.stream()
                        .filter(r -> (r instanceof ReservaHotel && countHotel >= 2) ||
                                (r instanceof ReservaBoleto && countBoleto >= 2)) // Filtra las reservas con descuento
                        .mapToDouble(Reserva::precio)
                        .sum() * 0.05; // Aplica 5% de descuento solo a estas reservas
            }

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
