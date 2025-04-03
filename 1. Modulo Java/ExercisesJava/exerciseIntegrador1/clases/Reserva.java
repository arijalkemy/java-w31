package exerciseIntegrador1.clases;

public abstract class Reserva {
    private Double precioReserva;
    private String tipoReserva;

    public abstract void obtenerPrecioReserva();

    public Double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(Double precioReserva) {
        this.precioReserva = precioReserva;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

}
