package modelos;

import enumeradores.Descuentos;
import enumeradores.TipoReserva;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Localizador {
    private Cliente cliente;
    private final List<Reserva> reservas;
    private double totalReservas;
    private final Map<Descuentos, Set<TipoReserva>> descuentosTipoReservas;

    public Localizador(Cliente cliente, Map<Descuentos, Set<TipoReserva>> tipoReservasParaDescuento, List<Reserva> reservas) {
        this.cliente = cliente;
        this.descuentosTipoReservas = tipoReservasParaDescuento;
        this.reservas = reservas;
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

    public double getTotalReservas() {
        return totalReservas;
    }

    public double getTotalReservasSinDescuento() {
        return reservas.stream().mapToDouble(Reserva::getValorReserva).sum();
    }

    public void setTotalReservas(double totalReservas) {
        this.totalReservas = totalReservas;
    }

    public Map<Descuentos, Set<TipoReserva>> getDescuentosTipoReservas() {
        return descuentosTipoReservas;
    }
}
