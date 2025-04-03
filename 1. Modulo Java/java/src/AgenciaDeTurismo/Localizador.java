package AgenciaDeTurismo;
import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.total = 0;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregaReserva(Reserva reserva) {
        reservas.add(reserva);
        total+=reserva.getCosto();
    }

    public double calcularTotalConDescuentos() {
        double totalConDescuentos = total;

        // aplicar descuento por clientes anteriores
        if (cliente.getLocalizadoresC() >= 2) {
            totalConDescuentos *= 0.95; // 5% de descuento
        }

        // verificar si hay un paquete completo
        boolean tienePaqueteCompleto = reservas.stream().filter(r -> r.getTipo().equals("hotel")).count() > 0 &&
                reservas.stream().filter(r -> r.getTipo().equals("comida")).count() > 0 &&
                reservas.stream().filter(r -> r.getTipo().equals("boleto")).count() > 0 &&
                reservas.stream().filter(r -> r.getTipo().equals("transporte")).count() > 0;

        if (tienePaqueteCompleto) {
            totalConDescuentos *= 0.90; // 10% de descuento
        }

        // descuentos adicionales
        long hospitalityCount = reservas.stream().filter(r -> r.getTipo().equals("hotel")).count();
        long travelCount = reservas.stream().filter(r -> r.getTipo().equals("boleto")).count();

        if (hospitalityCount >= 2) {
            totalConDescuentos *= 0.95; // 5% de descuento
        }
        if (travelCount >= 2) {
            totalConDescuentos *= 0.95; // 5% de descuento
        }

        return totalConDescuentos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("=== Localizador para: ").append(cliente).append(" ===\n");
        str.append("Reservas:\n");
        for (Reserva reserva : reservas) {
            str.append(reserva.getTipo()).append(": $").append(reserva.getCosto()).append("\n");
        }
        str.append("Total sin descuento: $").append(total);
        str.append("\nTotal con descuentos: $").append(calcularTotalConDescuentos());
        return str.toString();
    }
}
