package EjerciciosIntegradores.AgenciaDeTurismo.Version1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorySearch {
    private Repositorio repository;

    public RepositorySearch(Repositorio repository) {
        this.repository = repository;
    }

    public int getAmountofLocalizadores() {
        return this.repository.getLocalizadores().size();
    }

    public int getAmountofReservas() {
        return this.repository.getLocalizadores().stream().mapToInt(l -> l.getReservas().size()).sum();
    }

    public Map<TipoReserva, List<Reserva>> getReservasByType() {
        return this.repository.getLocalizadores().stream().map(Localizador::getReservas).flatMap(List::stream).collect(Collectors.groupingBy(Reserva::getTipoReserva));
    }

    public double getTotaldeVentas() {
        return this.repository.getLocalizadores().stream().map(Localizador::getPrecioTotal).reduce(0.0, Double::sum);
    }

    public double getVentasAvg() {
        double total = getTotaldeVentas();
        int totalReservas = getAmountofReservas();

        return (total / totalReservas);
    }
}
