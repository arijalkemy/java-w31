package com.mercadolimbre.modulojava.agenciadeturismo;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("diego", "434342323");
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        List<Reserva> reservas = new ArrayList();
        List<Reserva> reservas2 = new ArrayList();
        List<Reserva> reservas3 = new ArrayList();
        reservas.add(new ReservaComida(300000.0));
        reservas.add(new ReservaBoleto(500000.0));
        reservas.add(new ReservaHotel(200000.0));
        reservas.add(new ReservaTransporte(100000.0));
        System.out.println(new Localizador(cliente, reservas, repositorioCliente));

        reservas2.add(new ReservaHotel(200000.0));
        reservas2.add(new ReservaHotel(100000.0));
        reservas2.add(new ReservaBoleto(100000.0));
        reservas2.add(new ReservaBoleto(100000.0));
        System.out.println(new Localizador(cliente, reservas2, repositorioCliente));




        reservas3.add(new ReservaHotel(200000.0));
        System.out.println(new Localizador(cliente, reservas3, repositorioCliente));







        }
    }
