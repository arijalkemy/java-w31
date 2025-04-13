package org.example;

import org.example.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1,"Juan S");
        Cliente cliente2 = new Cliente(2,"Jose P");

        Reserva reserva1 = new Hotel(5000.);
        Reserva reserva2 = new Comida(1000.);
        Reserva reserva3 = new Tiquete(500.);
        Reserva reserva4 = new Transporte(25.);

        List<Reserva> reservaList = List.of(reserva1,reserva2,reserva3,reserva4);

        Localizador localizador = new Localizador(cliente1,reservaList);
    }
}