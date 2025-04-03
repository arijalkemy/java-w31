package Model;

public class Reserva {
    TipoReserva tipo;
    double precio;

    public Reserva(TipoReserva tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoReserva getTipo() {
        return tipo;
    }
}
