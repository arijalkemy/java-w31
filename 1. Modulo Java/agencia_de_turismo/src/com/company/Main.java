package com.company;

public class Main {
    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();

        Cliente cliente1 = new Cliente("Juan Pérez");
        Cliente cliente2 = new Cliente("Florencia");
        repositorio.agregarCliente(cliente1);
        repositorio.agregarCliente(cliente2);

        // PAQUETE COMPLETO
        System.out.println("---- Paquete Completo ----");
        Localizador paqueteFlorencia = new Localizador(cliente2);
        paqueteFlorencia.agregarReserva("hotel", 475.0);
        paqueteFlorencia.agregarReserva("comida", 95.0);
        paqueteFlorencia.agregarReserva("boletos", 190.0);
        paqueteFlorencia.agregarReserva("transporte", 142.5);
        paqueteFlorencia.aplicarDescuento();
        cliente2.agregarLocalizador(paqueteFlorencia);
        paqueteFlorencia.imprimirLocalizador();

        // 2 HOTELES Y 2 BOLETOS
        System.out.println("---- 2 Hoteles y 2 Boletos ----");
        Localizador multiReserva = new Localizador(cliente1);
        multiReserva.agregarReserva("hotel", 285.0);
        multiReserva.agregarReserva("hotel", 237.5);
        multiReserva.agregarReserva("boletos", 95.0);
        multiReserva.agregarReserva("boletos", 142.5);
        multiReserva.aplicarDescuento();
        cliente1.agregarLocalizador(multiReserva);
        multiReserva.imprimirLocalizador();


        // UNA SOLA RESERVA
        System.out.println("---- Una sola reserva ----");
        Localizador soloReserva = new Localizador(cliente1);
        soloReserva.agregarReserva("hotel", 95.0);
        soloReserva.aplicarDescuento();
        cliente1.agregarLocalizador(soloReserva);
        soloReserva.imprimirLocalizador();
    }
}

