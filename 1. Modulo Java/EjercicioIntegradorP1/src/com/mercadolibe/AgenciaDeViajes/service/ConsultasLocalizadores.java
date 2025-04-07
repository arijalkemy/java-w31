package com.mercadolibe.AgenciaDeViajes.service;

import com.mercadolibe.AgenciaDeViajes.model.Localizador;
import com.mercadolibe.AgenciaDeViajes.model.Reserva;
import com.mercadolibe.AgenciaDeViajes.model.TipoReserva;
import com.mercadolibe.AgenciaDeViajes.repository.RepositorioLocalizador;

import java.util.*;

public class ConsultasLocalizadores {
    private RepositorioLocalizador repoLocalizador;

    public ConsultasLocalizadores(RepositorioLocalizador repoLocalizador) {
        this.repoLocalizador = repoLocalizador;
    }

    public int cantidadLocalizadoresVendidos() {
        return repoLocalizador.getLocalizadores().size();
    }

    public int cantidadTotalReservas() {
        return repoLocalizador.getLocalizadores().stream()
                .mapToInt(localizador -> localizador.getReservas().size())
                .sum();
    }

    public Map<TipoReserva, Integer> obtenerReservasPorTipo() {
        Map<TipoReserva, Integer> reservasPorTipo = new HashMap<>();
        //inicializa el mapa con los tipos de reserva, y su contador con 0
        for (TipoReserva tipo : TipoReserva.values()) {
            reservasPorTipo.put(tipo,0);
        }

        //recorremos las reservas del localizador
        for (Localizador localizador : repoLocalizador.getLocalizadores()) {
            for (Reserva reserva : localizador.getReservas()) {
                reservasPorTipo.put(reserva.getTipo(), reservasPorTipo.get(reserva.getTipo()) + 1);
            }
        }

        return reservasPorTipo;
    }

    public double totalVentas() {
        return repoLocalizador.getLocalizadores().stream()
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public double promedioVentas() {
        int cantidadLocalizadores = cantidadLocalizadoresVendidos();
        return cantidadLocalizadores == 0 ? 0 : totalVentas() / cantidadLocalizadores;
    }
}