package clases;

import interfaces.Reserva;

public class ReservaBoleto extends Reserva {


    public ReservaBoleto(Double precio, Integer id) {
        super(precio, id);
    }

    @Override
    public String toString() {
        return "ReservaBoleto";
    }
}
