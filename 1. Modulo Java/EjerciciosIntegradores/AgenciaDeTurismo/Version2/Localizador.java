package EjerciciosIntegradores.AgenciaDeTurismo.Version2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double precioConDescuento;
    private boolean aplicaDescuento;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.precioConDescuento = calcularPrecio();
        this.aplicaDescuento = false;
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
        this.precioConDescuento = calcularPrecio();

    }

    private double calcularPrecio() {
        double precioHoteles = 0;
        double precioBoletos = 0;
        int cantHoteles = 0;
        int cantBoletos = 0;
        double costoRestante = 0;
        for (Reserva reserva : this.reservas) {
            if (reserva.getTipoReserva() == TipoReserva.HOTEL) {
                precioHoteles += reserva.getPrecioTotal();
                cantHoteles++;
            } else if (reserva.getTipoReserva() == TipoReserva.VUELO) {
                precioBoletos += reserva.getPrecioTotal();
                cantBoletos++;
            } else {
                costoRestante += reserva.getPrecioTotal();
            }
        }
        if (cantHoteles >= 2) {
            precioHoteles *= 0.95;
        }
        if (cantBoletos >= 2) {
            precioBoletos *= 0.95;
        }
        double precioTotal = precioHoteles + precioBoletos + costoRestante;
        Set<TipoReserva> tipoReservas = this.reservas.stream().map(Reserva::getTipoReserva).collect(Collectors.toSet());
        if (tipoReservas.containsAll(Set.of(TipoReserva.values()))) {
            precioTotal *= 0.90;
        }
        if (aplicaDescuento) {
            precioTotal *= 0.95;
        }
        return precioTotal;
    }

    public void aplicarDescuento() {
        this.aplicaDescuento = true;
        this.precioConDescuento = calcularPrecio();
    }

    public double getPrecio() {
        return precioConDescuento;
    }
}
