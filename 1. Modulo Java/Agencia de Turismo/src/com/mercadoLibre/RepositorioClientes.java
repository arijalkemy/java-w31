package com.mercadoLibre;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorioClientes {
    private Map<Cliente, List<Localizador>> datos = new HashMap<>();

    public void agregarLocalizador(Cliente cliente, Localizador localizador) {
        datos.computeIfAbsent(cliente, k -> new ArrayList<>()).add(localizador);
    }

    public int getTotalLocalizadoresVendidos() {
        return datos.values().stream().mapToInt(List::size).sum();
    }

    public int getTotalReservas() {
        return getTotalLocalizadoresVendidos();
    }

    public Map<TipoReserva, Long> getReservasPorTipo() {
        return datos.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Localizador::getTipo, Collectors.counting()));
    }

    public double getVentasTotales() {
        return datos.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Localizador::getTotal).sum();
    }

    public double getPromedioVentas() {
        int count = getTotalLocalizadoresVendidos();
        return count > 0 ? getVentasTotales() / count : 0;
    }
}

