package com.mercadolibre;

import java.util.LinkedList;

public class Main {
    public static void main (String [] args){

        SocorristaAuto socorristaAuto = new SocorristaAuto("Ornella");
        SocorristaMoto socorristaMoto = new SocorristaMoto("Alejo");


        Carrera carrera = new Carrera(500.0, 10000.0, "Gran Premio", 5, socorristaAuto, socorristaMoto);
        carrera.setVehiculos(new LinkedList<>());


        carrera.darDeAltaAuto(200.0, 50.0, 30.0, "ABC123");
        carrera.darDeAltaAuto(220.0, 45.0, 28.0, "DEF456");
        carrera.darDeAltaMoto(180.0, 55.0, 25.0, "GHI789");
        carrera.darDeAltaMoto(190.0, 52.0, 27.0, "JKL012");

        carrera.vehiculoGanador();


        carrera.socorrerAuto("ABC123");

        carrera.socorrerMoto("GHI789");

        carrera.eliminarVehiculoConPatente("DEF456");

        carrera.vehiculoGanador();
        }
    }

