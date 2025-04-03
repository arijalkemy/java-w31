package EjerciciosIntegradores.AgenciaDeTurismo.Version2;

public class Reserva {
    private double precioTotal;
    private TipoReserva tipoReserva;

    public Reserva(double precioTotal, TipoReserva tipoReserva) {
        this.precioTotal = precioTotal;
        this.tipoReserva = tipoReserva;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }
}
