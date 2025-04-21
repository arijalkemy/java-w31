package agenciaDeTurismo;

import java.util.Arrays;
import java.util.List;

public class Localizador {
    private String cliente;
    private List<Reserva> reservas;

    public Localizador(String cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double calcularTotal() {
        return reservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }

    public double aplicarDescuentos(RepositorioCliente repositorio) {
        double total = calcularTotal();

        if (repositorio.cantidadLocalizadores(cliente) >= 2) {
            total *= 0.95;
        }

        if (reservas.size() == 4 && reservas.stream().allMatch(r -> Arrays.asList("hotel", "comida", "boleto", "transporte").contains(r.getTipo()))) {
            total *= 0.90;
        }

        long cantidadHoteles = reservas.stream().filter(r -> r.getTipo().equals("hotel")).count();
        long cantidadBoletos = reservas.stream().filter(r -> r.getTipo().equals("boleto")).count();
        if (cantidadHoteles >= 2 || cantidadBoletos >= 2) {
            total *= 0.95;
        }

        return total;
    }


}
