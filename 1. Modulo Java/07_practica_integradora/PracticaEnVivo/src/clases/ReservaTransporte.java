package clases;

import interfaces.Reserva;

public class ReservaTransporte extends Reserva {
    public ReservaTransporte(Double precio, Integer id) {
        super(precio, id);
    }

    @Override
    public String toString() {
        return "ReservaTransporte";
    }
}
