package ejercicio_turismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.OptionalDouble;

import ejercicio_turismo.Model.Reserva;
import ejercicio_turismo.Repository.RepositorioLocalizador;

public class ParteDos {
    public static Long cantidadLocalizadores(RepositorioLocalizador repository) {
        return repository.getAll().values().stream().count();
    }

    public static Long cantidadReservas(RepositorioLocalizador repository) {
        return repository.getAll().values().stream()
                .flatMap(localizador -> localizador.getReservas().stream())
                .count();
    }

    public static HashMap<String, ArrayList<Reserva>> reservasPorTipo(RepositorioLocalizador repository) {
        HashMap<String, ArrayList<Reserva>> dct = new HashMap();
        repository.getAll().values().stream()
                .flatMap(localizador -> localizador.getReservas().stream())
                .forEach(reserva -> {
                    String tipo = reserva.getTipoReserva().toString();
                    if (dct.get(tipo) != null) {
                        dct.get(tipo).add(reserva);
                    } else {
                        ArrayList<Reserva> reservas = new ArrayList<>();
                        reservas.add(reserva);
                        dct.put(tipo, reservas);
                    }
                });
        return dct;
    }

    public static Double totalVentas(RepositorioLocalizador repository) {
        return repository.getAll().values().stream()
                .flatMap(localizador -> localizador.getReservas().stream())
                .mapToDouble(reserva -> reserva.getPrecio())
                .sum();
    }

    public static Double promedioReservas(RepositorioLocalizador repository) {
        return repository.getAll().values().stream()
                .flatMap(localizador -> localizador.getReservas().stream())
                .mapToDouble(reserva -> reserva.getPrecio())
                .average().getAsDouble();
    }
}
