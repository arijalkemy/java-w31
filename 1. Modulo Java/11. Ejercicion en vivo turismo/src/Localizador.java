import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularTotalConDescuentos();
    }

    private double calcularTotalConDescuentos() {
        double subtotal = 0;
        int hoteles = 0, boletosViaje = 0;

        for (Reserva reserva : reservas) {
            subtotal += reserva.getCosto();
            if (reserva.getTipo() == Reserva.TipoReserva.HOTEL) hoteles++;
            if (reserva.getTipo() == Reserva.TipoReserva.BOLETO_VIAJE) boletosViaje++;
        }

        // Descuentos por paquetes completos
        boolean paqueteCompleto = reservas.stream().map(Reserva::getTipo).distinct().count() == 4;
        if (paqueteCompleto) subtotal *= 0.90; // 10% descuento

        // 5% descuento por 2 reservas de hotel o 2 boletos de viaje
        if (hoteles >= 2) subtotal -= (reservas.stream().filter(r -> r.getTipo() == Reserva.TipoReserva.HOTEL).mapToDouble(Reserva::getCosto).sum() * 0.05);
        if (boletosViaje >= 2) subtotal -= (reservas.stream().filter(r -> r.getTipo() == Reserva.TipoReserva.BOLETO_VIAJE).mapToDouble(Reserva::getCosto).sum() * 0.05);

        // 5% descuento por 2 localizadores previos
        if (cliente.getLocalizadores().size() >= 2) subtotal *= 0.95;

        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Localizador para: ").append(cliente.getNombre()).append("\n");
        for (Reserva reserva : reservas) {
            sb.append("- ").append(reserva.getTipo()).append(": ").append(reserva.getCosto()).append("\n");
        }
        sb.append("Total (con descuentos aplicados): ").append(total).append("\n");
        return sb.toString();
    }
}
