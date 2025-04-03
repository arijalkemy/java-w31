package clases;

import interfaces.Reserva;

public class ReservaHotel extends Reserva {


    public ReservaHotel(Double precio, Integer id) {
        super(precio, id);
    }

    @Override
    public String toString() {
        return "ReservaHotel";
    }
}
