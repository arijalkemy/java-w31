package agenciaDeTurismo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DescuentosService {
    private final LocalizadoresRepository localizadoresRepository;

    public DescuentosService(LocalizadoresRepository localizadoresRepository) {
        this.localizadoresRepository = localizadoresRepository;
    }

    public double aplicarDescuentos(Cliente cliente, List<Reserva> reservas) {
        double total = reservas.stream().mapToDouble(Reserva::getPrecioTotal).sum();
        total -= aplicarDescuentosPorTipo(reservas, List.of(TipoReserva.HOTEL, TipoReserva.VUELO));

        if(esPaqueteCompleto(reservas)) {
            total = total * 0.90;
        }

        int cantReservasPrevias = localizadoresRepository.getClienteAmountofLocalizadores(cliente.getDni());
        if (cantReservasPrevias >= 2) {
            total = total * 0.95;
        }

        return total;
    }

    private boolean esPaqueteCompleto(List<Reserva> reservas) {
        Set<TipoReserva> tipos = reservas.stream().map(Reserva::getTipoReserva).collect(Collectors.toSet());
        return tipos.containsAll(Set.of(TipoReserva.values()));
    }

    private double aplicarDescuentosPorTipo(List<Reserva> reservas, List<TipoReserva> reservasConDescuento) {
        double descuento = 0.0;
        Set<TipoReserva> tiposDeReserva = reservas.stream().map(Reserva::getTipoReserva).collect(Collectors.toSet());

        for(TipoReserva tipo : tiposDeReserva) {
            if (reservasConDescuento.contains(tipo)) {
                long count = reservas.stream().filter(r -> r.getTipoReserva().equals(tipo)).count();
                if (count >= 2) {
                    descuento += reservas.stream()
                            .filter(r -> r.getTipoReserva() == tipo)
                            .mapToDouble(r -> r.getPrecioTotal() * 0.05)
                            .sum();
                }
            }
        }
        return descuento;
    }
}
