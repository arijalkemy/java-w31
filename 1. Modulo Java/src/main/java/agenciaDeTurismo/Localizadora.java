package agenciaDeTurismo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Localizadora {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double precioTotal;

    public Localizadora(Cliente cliente, List<Reserva> reservas, DescuentosService descuentosService) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.precioTotal = descuentosService.aplicarDescuentos(cliente, reservas);
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

    public double getPrecioTotal() {
        return precioTotal;
    }
}
