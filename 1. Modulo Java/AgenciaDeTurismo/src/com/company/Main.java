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
        Localizador l1 = new Localizador(c1,reservas);

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        repositorioCliente.agregarLocalizador(l1);

        //Agregando otro localizador al mismo cliente
        Localizador l2 = new Localizador(c1,reservas);
        repositorioCliente.agregarLocalizador(l2);

        //Podemos mostrar el localizador
        repositorioCliente.mostrarInfo();

        //Consultamos cuantos localizadores tiene un cliente
        if (repositorioCliente.consultarCantidadLocalizador(c1) >=2){
            c1.setDescuentox2Localizadores(true);
        }

        //Antes de crear un nuevo localizador debo consultar si el cliente tiene algun descuento
    }
}
