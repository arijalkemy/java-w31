package modelos;

import enumeradores.TipoReserva;

public class Reserva {
    private final TipoReserva tipoReserva;
    private final double valorReserva;

    public Reserva(TipoReserva tipoReserva, double valorReserva) {
        this.tipoReserva = tipoReserva;
        this.valorReserva = valorReserva;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public double getValorReserva() {
        return valorReserva;
    }
}
