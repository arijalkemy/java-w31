package clases;

import interfaces.Reserva;

public class ReservaComida extends Reserva {


    public ReservaComida(Double precio, Integer id) {
        super(precio, id);
    }

    @Override
    public String toString() {
        return "ReservaComida";
    }
}
