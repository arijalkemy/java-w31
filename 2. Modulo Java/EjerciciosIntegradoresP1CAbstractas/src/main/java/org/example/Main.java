package org.example;

import org.example.model.Hija1;
import org.example.model.Hija2;
import org.example.model.Hija3;

public class Main {
    public static void main(String[] args) {
        Hija1 hija1 = new Hija1();
        Hija2 hija2 = new Hija2();
        Hija3 hija3 = new Hija3();

        System.out.println("------HIJA 1------");
        hija1.setInicioSerie(0);
        hija1.setPasoEntreSerie(2);
        System.out.println(hija1.siguienteNumero());
        System.out.println(hija1.siguienteNumero());
        System.out.println(hija1.siguienteNumero());
        System.out.println(hija1.siguienteNumero());
        hija1.reiniciarSerie();
        System.out.println(hija1.siguienteNumero());
        System.out.println("------HIJA 2------");
        hija2.setInicioSerie(1);
        hija2.setPasoEntreSerie(2);
        System.out.println(hija2.siguienteNumero());
        System.out.println(hija2.siguienteNumero());
        System.out.println(hija2.siguienteNumero());
        System.out.println(hija2.siguienteNumero());
        System.out.println("------HIJA 3------");
        hija3.setInicioSerie(0);
        hija3.setPasoEntreSerie(3);
        System.out.println(hija3.siguienteNumero());
        System.out.println(hija3.siguienteNumero());
        System.out.println(hija3.siguienteNumero());
        System.out.println(hija3.siguienteNumero());

    }
}