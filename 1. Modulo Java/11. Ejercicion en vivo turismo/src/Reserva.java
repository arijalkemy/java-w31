public class Reserva {
    public enum TipoReserva {
        HOTEL, COMIDA, BOLETO_VIAJE, TRANSPORTE
    }

    private TipoReserva tipo;
    private double costo;

    public Reserva(TipoReserva tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }
}
