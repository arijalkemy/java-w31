package Model;

import java.util.List;

public class Localizador {
    Cliente cliente;
    List<Reserva> reservas;
    double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularTotal(); // aplico los descuentos
        printLocalizador();
    }

    public void printLocalizador() {
        System.out.println("Se gestionaron las siguientes reservas por TOTAL = " + this.total);
        this.reservas.forEach(reserva -> System.out.println(reserva.getPrecio()));
    }

    public double calcularTotal() {
        double subtotal = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
        double descuento = calcularDescuento(subtotal);
        return subtotal - descuento;
    }

    public double calcularDescuento(double subtotal) {
        double descuento = 0;

        // Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras compras.
        if (this.cliente.tieneAlMenos2Localizadores()) descuento += subtotal * 0.05;

        // Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
        if (    this.getCantReservas(TipoReserva.BOLETO) >= 1 &&
                this.getCantReservas(TipoReserva.COMIDA) >= 1 &&
                this.getCantReservas(TipoReserva.HOTEL) >= 1 &&
                this.getCantReservas(TipoReserva.TRANSPORTE) >= 1
        ) descuento += subtotal * 0.1;

        // Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
        if (this.getCantReservas(TipoReserva.HOTEL) >= 2) descuento += getTotalReservaPorTipo(TipoReserva.HOTEL) * 0.1;
        if (this.getCantReservas(TipoReserva.BOLETO) >= 2) descuento += getTotalReservaPorTipo(TipoReserva.BOLETO) * 0.1;

        return descuento;
    }

    private List<Reserva> getReservasPorTipo(TipoReserva tipo) {
        return this.reservas.stream().filter(reserva -> reserva.getTipo() == tipo).toList();
    }

    private int getCantReservas(TipoReserva tipo) {
        return this.getReservasPorTipo(tipo).size();
    }

    private double getTotalReservaPorTipo(TipoReserva tipo) {
        return this.getReservasPorTipo(tipo).stream().mapToDouble(Reserva::getPrecio).sum();
    }

}
