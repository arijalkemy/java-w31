package ejercicio_turismo.Model;

public class Reserva {
    private TipoReserva tipoReserva;
    private Double precio;

    public Reserva(TipoReserva tipoReserva, Double precio) {
        this.tipoReserva = tipoReserva;
        this.precio = precio;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva [tipoReserva=" + tipoReserva + ", precio=" + precio + "]";
    }
}
