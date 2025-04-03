package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Creamos cliente
        Cliente c1 = new Cliente("38220103","Miguel","Bustos");

        //Creamos las 4 reservas
        ReservaComida reservaComida = new ReservaComida(5500D);
        ReservaTransporte reservaTransporte = new ReservaTransporte(15000D);
        ReservaBoleto reservaBoleto = new ReservaBoleto(3500D);
        ReservaHotel reservaHotel = new ReservaHotel(60000D);

        //Creo una lista con las reservas
        List<Reserva> reservas = new ArrayList<Reserva>();
        reservas.add(reservaComida);
        reservas.add(reservaTransporte);
        reservas.add(reservaBoleto);
        reservas.add(reservaHotel);

        //Creamos un localizador completo
        Localizador localizador = new Localizador(c1,reservas);

        //Imprimimos el resultado
        localizador.calcularDescuento();


    }
}
