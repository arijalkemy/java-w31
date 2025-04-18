package org.example;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularTotalConDescuentos();
        cliente.agregarLocalizador(this);
    }

    private double calcularTotalConDescuentos() {
        double subtotal = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
        double descuento = 0.0;

        // Descuento por historial
        if (cliente.getHistorial().size() >= 2) {
            descuento += 0.05;
        }

        // Verifica si es un paquete completo
        boolean tieneHotel = false, tieneComida = false, tieneBoleto = false, tieneTransporte = false;
        int hoteles = 0, boletos = 0;

        for (Reserva r : reservas) {
            switch (r.getTipo().toLowerCase()) {
                case "hotel" -> {
                    tieneHotel = true;
                    hoteles++;
                }
                case "comida" -> tieneComida = true;
                case "boleto" -> {
                    tieneBoleto = true;
                    boletos++;
                }
                case "transporte" -> tieneTransporte = true;
            }
        }

        // Paquete completo
        if (tieneHotel && tieneComida && tieneBoleto && tieneTransporte) {
            descuento += 0.10;
        }

        // Dos reservas de hotel o boleto
        if (hoteles >= 2 || boletos >= 2) {
            subtotal -= reservas.stream()
                    .filter(r -> r.getTipo().equalsIgnoreCase("hotel") || r.getTipo().equalsIgnoreCase("boleto"))
                    .limit(2)
                    .mapToDouble(r -> r.getPrecio() * 0.05)
                    .sum();
        }

        return subtotal * (1 - descuento);
    }

    public void imprimir() {
        System.out.println("Cliente: " + cliente.getNombre());
        reservas.forEach(System.out::println);
        System.out.printf("Total con descuentos: $%.2f%n", total);
        System.out.println("-----------");
    }
}

