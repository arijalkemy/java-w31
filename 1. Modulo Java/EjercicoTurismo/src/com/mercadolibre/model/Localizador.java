package com.mercadolibre.model;

import java.util.LinkedList;

public class Localizador {
    private Cliente cliente;
    private LinkedList<Reserva> reservas = new LinkedList<>();
    private Double total;

    public Localizador(Cliente cliente, LinkedList<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularTotal();
    }

    private Double calcularTotal() {
        double suma = 0.0;
        if (reservas != null) {
            for (Reserva r : reservas) {
                suma += r.getProductos().stream()
                        .mapToDouble(Producto::getPrecio)
                        .sum();
            }
        }
        return suma;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void realizarDescuento() {
        Double descuento = 0.0;

        if (cliente.getLocalizadores().size() >= 2) {
            descuento += 0.05;
        }

        if (tienePaqueteCompleto()) {
            descuento += 0.10;
        }

        if (tieneDosHotelesODosBoletos()) {
            descuento += 0.05;
        }

        total -= total * descuento;
    }

    private boolean tienePaqueteCompleto() {
        if (reservas == null) {
            return false;
        }

        return reservas.stream().anyMatch(r ->
                r.getProductos().contains(TipoProducto.HOTEL) &&
                        r.getProductos().contains(TipoProducto.BOLETO_DE_VIAJE) &&
                        r.getProductos().contains(TipoProducto.TRANSPORTE) &&
                        r.getProductos().contains(TipoProducto.COMIDA)
        );
    }

    private boolean tieneDosHotelesODosBoletos() {
        if (reservas == null) {
            return false;
        }

        long contadorHoteles = reservas.stream()
                .filter(r -> r.getProductos().contains(TipoProducto.HOTEL))
                .count();

        long contadorBoletos = reservas.stream()
                .filter(r -> r.getProductos().contains(TipoProducto.BOLETO_DE_VIAJE))
                .count();

        return contadorHoteles >= 2 || contadorBoletos >= 2;
    }
}
