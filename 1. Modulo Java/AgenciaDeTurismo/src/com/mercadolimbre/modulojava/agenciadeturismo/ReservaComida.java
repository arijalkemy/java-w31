package com.mercadolimbre.modulojava.agenciadeturismo;

public class ReservaComida extends Reserva {
    public ReservaComida(double precio) {
        super(precio);
    }

    public String getTipo() {
        return "comida";
    }
    @Override
    public String toString() {
        return "Reserva Comida{" +
                "precio=" + this.getPrecio() +
                '}';
    }

}
