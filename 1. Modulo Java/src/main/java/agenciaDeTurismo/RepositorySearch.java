package agenciaDeTurismo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorySearch {
    private LocalizadoresRepository repository;

    public RepositorySearch(LocalizadoresRepository repository) {
        this.repository = repository;
    }

    public int getAmountofLocalizadores() {
        return this.repository.getLocalizadores().size();
    }

    public int getAmountofReservas() {
        return this.repository.getLocalizadores().stream().mapToInt(l -> l.getReservas().size()).sum();
    }

    public Map<TipoReserva, List<Reserva>> getReservasByType() {
        HashMap<TipoReserva, List<Reserva>> reservas = new HashMap<>();
        return this.repository.getLocalizadores().stream().map(Localizadora::getReservas).flatMap(List::stream).collect(Collectors.groupingBy(Reserva::getTipoReserva));
    }

    public double getTotaldeVentas() {
        return this.repository.getLocalizadores().stream().map(Localizadora::getPrecioTotal).reduce(0.0, Double::sum);
    }

    public double getVentasAvg() {
        double total = getTotaldeVentas();
        int totalReservas = getAmountofReservas();

        return (total / totalReservas);
    }
}
