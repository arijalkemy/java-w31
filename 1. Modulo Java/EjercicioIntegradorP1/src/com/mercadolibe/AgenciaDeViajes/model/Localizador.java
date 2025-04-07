package com.mercadolibe.AgenciaDeViajes.model;

import com.mercadolibe.AgenciaDeViajes.repository.RepositorioLocalizador;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas, double total) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        total += reserva.getPrecio();
    }

    public double obtenerTotalConDescuento(RepositorioLocalizador repoLocalizador) {
        double descuento = 0;
        double totalConDescuento = total;


        List<Localizador> localizadoresCliente = repoLocalizador.buscarLocalizadoresPorCliente(cliente);
        if (localizadoresCliente.size() >= 2) {
            descuento += total * 0.05;
        }

        if (reservas.stream().anyMatch(res -> res.getTipo() == TipoReserva.HOTEL) &&
                reservas.stream().anyMatch(res -> res.getTipo() == TipoReserva.COMIDA) &&
                reservas.stream().anyMatch(res -> res.getTipo() == TipoReserva.BOLETO) &&
                reservas.stream().anyMatch(res -> res.getTipo() == TipoReserva.TRANSPORTE)) {
            descuento += total * 0.10;
        }

        long conteoHotel = reservas.stream().filter(res -> res.getTipo() == TipoReserva.HOTEL).count();
        long conteoBoletos = reservas.stream().filter(res -> res.getTipo() == TipoReserva.BOLETO).count();

        if (conteoHotel >= 2) {
            double totalHoteles = reservas.stream()
                    .filter(res -> res.getTipo() == TipoReserva.HOTEL)
                    .mapToDouble(Reserva::getPrecio)
                    .sum();
            descuento += totalHoteles * 0.05;
        }

        if (conteoBoletos >= 2) {
            double totalBoletos = reservas.stream()
                    .filter(res -> res.getTipo() == TipoReserva.BOLETO)
                    .mapToDouble(Reserva::getPrecio)
                    .sum();
            descuento += totalBoletos * 0.05;
        }

        totalConDescuento -= descuento;
        return totalConDescuento;
    }

    private double calcularTotal() {
        double suma = 0;
        for (Reserva reserva : reservas) {
            suma += reserva.getPrecio();
        }
        return suma;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }


    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente.getNombre() +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }

    public void imprimirDetalles(RepositorioLocalizador repoLocalizador) {
        System.out.println("Localizador para: " + cliente.getNombre());
        for (Reserva reserva : reservas) {
            System.out.println("- " + reserva.getTipo() + ": $" + reserva.getPrecio());
        }
        System.out.println("Total sin descuentos: $" + total);
        System.out.println("Total con descuentos: $" + obtenerTotalConDescuento(repoLocalizador));
    }
}
