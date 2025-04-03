package com.mercadolibre.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main (String []args){
        /*Presentar un escenario donde:

        Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
        Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
        Crear un localizador con una sola reserva para el mismo cliente.
        Verificar que los descuentos fueron aplicados.*/
        Producto p = new Producto(TipoProducto.HOTEL, 30000.0);
        Producto p2 = new Producto(TipoProducto.BOLETO_DE_VIAJE, 20000.0);
        Producto p3 = new Producto(TipoProducto.HOTEL, 50000.0);
        Producto p4 = new Producto(TipoProducto.BOLETO_DE_VIAJE, 15000.0);
        Producto p5 = new Producto(TipoProducto.COMIDA, 150000.0);
        Producto p6 = new Producto(TipoProducto.TRANSPORTE, 300000.0);

        Reserva r = new Reserva();
        r.agregarProductoAReserva(p);
        r.agregarProductoAReserva(p2);
        r.agregarProductoAReserva(p5);
        r.agregarProductoAReserva(p6);

        Reserva r2 = new Reserva();
        r2.agregarProductoAReserva(p);
        r2.agregarProductoAReserva(p2);
        r2.agregarProductoAReserva(p3);
        r2.agregarProductoAReserva(p4);

        LinkedList<Reserva> reservas = new LinkedList<>();
        reservas.add(r);
        LinkedList<Reserva> reservas2 = new LinkedList<>();
        reservas.add(r);
        LinkedList<Reserva> reservas3 = new LinkedList<>();
        reservas.add(r);

        LinkedList<Reserva> reservas4 = new LinkedList<>();
        reservas4.add(r2);

        Cliente c = new Cliente ("Ornella", "Alonso", "12341234");
        Cliente c2 = new Cliente ("Alejo", "Melissari", "123412341");


        Localizador l = new Localizador(c, reservas);
        Localizador l2 = new Localizador(c, reservas2);
        Localizador l3 = new Localizador(c, reservas3);
        c.agregarLocalizador(l2);
        c.agregarLocalizador(l3);


        // Escenario 1 y 2
        l.realizarDescuento();
        System.out.println("Total con descuento: $" + l.getTotal());



        // Escenario 3
        Localizador l4 = new Localizador(c2, reservas4);
        l4.realizarDescuento();
        System.out.println("Total con descuento: $" + l4.getTotal());


    }

    }

