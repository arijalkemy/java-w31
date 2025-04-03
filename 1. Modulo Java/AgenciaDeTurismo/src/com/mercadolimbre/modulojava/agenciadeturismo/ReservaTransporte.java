package com.mercadolimbre.modulojava.agenciadeturismo;

public class ReservaTransporte extends Reserva {
    public ReservaTransporte(double precio) {
        super(precio);
    }

    public String getTipo() {
        return "transporte";
    }
    @Override
    public String toString() {
        return "Reserva Transporte{" +
                "precio=" + this.getPrecio() +
                '}';
    }
}
