package com.mercadolibre.agenciaDeViajes.model;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private Double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Double getTotal() {
        return total;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        this.total = calcularTotal();
    }

    private Double calcularTotal() {
        return reservas.stream().mapToDouble(Reserva::getValor).sum();
    }

    private Boolean esPaqueteCompleto() {
        Boolean hotel = false;
        Boolean comida = false;
        Boolean boletos = false;
        Boolean transporte = false;

        for (Reserva reserva : reservas) {
            if (reserva.getTipoReserva().equals(TipoReserva.HOTEL)) {
                hotel = true;
            }
            if (reserva.getTipoReserva().equals(TipoReserva.COMIDA)) {
                comida = true;
            }
            if (reserva.getTipoReserva().equals(TipoReserva.BOLETO)) {
                boletos = true;
            }
            if (reserva.getTipoReserva().equals(TipoReserva.TRANSPORTE)) {
                transporte = true;
            }
        }
        return hotel && comida && boletos && transporte;
    }

    public void aplicarDescuentos() {
        if (cliente.getCantidadLocalizadores() >= 2) {
            total -= (total * 0.05);
        }
        if (esPaqueteCompleto()) {
            total -= (total * 0.10);
        }
        if (
                (reservas.stream()
                         .filter(reserva -> reserva.getTipoReserva().equals(TipoReserva.HOTEL))
                         .count() >= 2) ||
                (reservas.stream()
                         .filter(reserva -> reserva.getTipoReserva().equals(TipoReserva.BOLETO))
                         .count() >= 2) ) {


        }
    }


}
