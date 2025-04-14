package com.mercadoLibre;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RepositorioClientes repo = new RepositorioClientes();

        Cliente cliente1 = new Cliente("Jane Doe");

        Localizador paqueteCompleto = new Localizador(cliente1, TipoReserva.HOTEL, 100);
        cliente1.agregarLocalizador(paqueteCompleto);
        repo.agregarLocalizador(cliente1, paqueteCompleto);

        Localizador comida = new Localizador(cliente1, TipoReserva.COMIDA, 50);
        cliente1.agregarLocalizador(comida);
        repo.agregarLocalizador(cliente1, comida);

        Localizador boletos = new Localizador(cliente1, TipoReserva.BOLETO, 200);
        cliente1.agregarLocalizador(boletos);
        repo.agregarLocalizador(cliente1, boletos);

        Localizador transporte = new Localizador(cliente1, TipoReserva.TRANSPORTE, 75);
        cliente1.agregarLocalizador(transporte);
        repo.agregarLocalizador(cliente1, transporte);

        paqueteCompleto.aplicarDescuento();
        comida.aplicarDescuento();
        boletos.aplicarDescuento();
        transporte.aplicarDescuento();

        System.out.println("\n---- Paquete Completo ----");
        paqueteCompleto.imprimirLocalizador();
        comida.imprimirLocalizador();
        boletos.imprimirLocalizador();
        transporte.imprimirLocalizador();

        Localizador hotel1 = new Localizador(cliente1, TipoReserva.HOTEL, 120);
        cliente1.agregarLocalizador(hotel1);
        repo.agregarLocalizador(cliente1, hotel1);
        Localizador hotel2 = new Localizador(cliente1, TipoReserva.HOTEL, 130);
        cliente1.agregarLocalizador(hotel2);
        repo.agregarLocalizador(cliente1, hotel2);
        Localizador boleto1 = new Localizador(cliente1, TipoReserva.BOLETO, 220);
        cliente1.agregarLocalizador(boleto1);
        repo.agregarLocalizador(cliente1, boleto1);
        Localizador boleto2 = new Localizador(cliente1, TipoReserva.BOLETO, 230);
        cliente1.agregarLocalizador(boleto2);
        repo.agregarLocalizador(cliente1, boleto2);

        hotel1.aplicarDescuento();
        hotel2.aplicarDescuento();
        boleto1.aplicarDescuento();
        boleto2.aplicarDescuento();

        System.out.println("\n---- 2 Hoteles y 2 Boletos ----");
        hotel1.imprimirLocalizador();
        hotel2.imprimirLocalizador();
        boleto1.imprimirLocalizador();
        boleto2.imprimirLocalizador();

        Localizador soloReserva = new Localizador(cliente1, TipoReserva.HOTEL, 60);
        cliente1.agregarLocalizador(soloReserva);
        repo.agregarLocalizador(cliente1, soloReserva);
        soloReserva.aplicarDescuento();

        System.out.println("\n---- Una sola reserva ----");
        soloReserva.imprimirLocalizador();

        System.out.println("\n---- Consultas ----");
        System.out.println("Cantidad de localizadores vendidos: " + repo.getTotalLocalizadoresVendidos());
        System.out.println("Cantidad total de reservas: " + repo.getTotalReservas());

        Map<TipoReserva, Long> reservasPorTipo = repo.getReservasPorTipo();
        System.out.println("Reservas por tipo:");
        reservasPorTipo.forEach((tipo, cantidad) -> System.out.println(tipo + ": " + cantidad));

        System.out.println("Total de ventas: " + repo.getVentasTotales());
        System.out.println("Promedio de ventas: " + repo.getPromedioVentas());
    }
}

