package agenciaturismo.models;

import java.util.HashSet;
import java.util.Set;

public class Localizador {

    private int id;
    private Cliente cliente;
    private final Set<Reserva> reservas;
    private Double totalReservasSinDescuento;
    private Double totalReservasConDescuento;

    public Localizador(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = new HashSet<>();
        this.totalReservasSinDescuento = 0.0;
        this.totalReservasConDescuento = 0.0;
    }

    public int getCantidadReservas() {
        return reservas.size();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        totalReservasSinDescuento = calcularTotalSinDescuento();
        totalReservasConDescuento = calcularTotalReservasConDescuento();
    }

    /**
     * Calcula el total sin aplicar descuentos.
     */
    private Double calcularTotalSinDescuento() {
        return reservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }

    /**
     * Calcula el total con los descuentos aplicados.
     */
    public Double calcularTotalReservasConDescuento() {
        double totalSinDescuento = calcularTotalSinDescuento();
        double totalConDescuento = totalSinDescuento;

        if (esPaqueteCompleto()) {
            totalConDescuento -= aplicarDescuento(totalSinDescuento, 10);
        }

        if (tieneDescuentoPorReservaEspecifica()) {
            totalConDescuento -= aplicarDescuento(totalSinDescuento, 5);
        }

        return totalConDescuento;
    }

    /**
     * Verifica si el localizador contiene un paquete completo (Hotel,
     * Transporte, Comida, Viaje).
     */
    private boolean esPaqueteCompleto() {
        boolean tieneHotel = false, tieneTransporte = false, tieneComida = false, tieneViaje = false;

        for (Reserva reserva : reservas) {
            if (reserva instanceof Hotel) {
                tieneHotel = true;
            } else if (reserva instanceof Transporte) {
                tieneTransporte = true;
            } else if (reserva instanceof Comida) {
                tieneComida = true;
            } else if (reserva instanceof Viajes) {
                tieneViaje = true;
            }
        }

        return tieneHotel && tieneTransporte && tieneComida && tieneViaje;
    }

    /**
     * Verifica si el cliente tiene al menos 2 reservas de hotel o 2 boletos de
     * viaje.
     */
    private boolean tieneDescuentoPorReservaEspecifica() {
        long cantidadHoteles = reservas.stream().filter(r -> r instanceof Hotel).count();
        long cantidadBoletos = reservas.stream().filter(r -> r instanceof Viajes).count();
        return cantidadHoteles >= 2 || cantidadBoletos >= 2;
    }

    /**
     * Aplica un porcentaje de descuento al total.
     */
    private double aplicarDescuento(double total, double porcentaje) {
        return total * (porcentaje / 100);
    }

    @Override
    public String toString() {
        return "Localizador{"
                + "id=" + id
                + ", cliente=" + cliente
                + ", reservas=" + reservas
                + '}';
    }
}
