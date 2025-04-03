package agenciaDeTurismo;

public class Reserva {
    private double precioTotal;
    private TipoReserva tipoReserva;
    private boolean descuentoTipoAplicado;

    public Reserva(double precioTotal, TipoReserva tipoReserva) {
        this.precioTotal = precioTotal;
        this.tipoReserva = tipoReserva;
        this.descuentoTipoAplicado = false;
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

    public void aplicarDescuento(double descuento) {
        if (!this.descuentoTipoAplicado) {
            double cantidadDescuento = this.precioTotal * descuento;
            this.precioTotal = this.precioTotal - cantidadDescuento;
            this.descuentoTipoAplicado = true;
        }
    }
}
