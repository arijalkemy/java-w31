package com.mercadolimbre.modulojava.agenciadeturismo;

public class ReservaHotel extends Reserva {
    public ReservaHotel(double precio) {
        super(precio);
    }

    public String getTipo() {
        return "hotel";
    }
    @Override
    public String toString() {
        return "Reserva Hotel{" +
                "precio=" + this.getPrecio() +
                '}';
    }
}
