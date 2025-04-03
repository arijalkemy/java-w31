package agenciaDeTurismo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Localizadora {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double precioTotal;

    public Localizadora(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        checkDescuentoReserva(TipoReserva.HOTEL);
        checkDescuentoReserva(TipoReserva.VUELO);
        this.precioTotal = reservas.stream().map(Reserva::getPrecioTotal).reduce(0.0, Double::sum);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva nuevaReserva) {
        this.reservas.add(nuevaReserva);
        this.precioTotal += nuevaReserva.getPrecioTotal();

    }

    private void checkDescuentoReserva(TipoReserva tipoReserva) {
        if (this.reservas.stream().filter(r -> r.getTipoReserva() == tipoReserva).count() >= 2) {
            for (Reserva reserva : this.reservas) {
                if (reserva.getTipoReserva() == tipoReserva) {
                    reserva.aplicarDescuento(0.05);
                }
            }
        }
    }

    public double getPrecioTotal() {
        Set<TipoReserva> tipoReservas = this.reservas.stream().map(Reserva::getTipoReserva).collect(Collectors.toSet());
        if (tipoReservas.containsAll(Set.of(TipoReserva.values()))) {
            return precioTotal * 0.90;
        }
        return precioTotal;
    }

    public void aplicarDescuento(double descuento) {
        double totalDescuento = this.precioTotal * descuento;
        this.precioTotal -= totalDescuento;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
