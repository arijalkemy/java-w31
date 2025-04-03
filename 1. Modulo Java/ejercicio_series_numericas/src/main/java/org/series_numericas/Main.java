package org.series_numericas;

import org.series_numericas.clases.SerieCustom;
import org.series_numericas.clases.SerieImpar;
import org.series_numericas.clases.SeriePar;

public class Main {
    public static void main(String[] args) {
        int value = 2;

        SeriePar numeroPar = new SeriePar();
        numeroPar.setInitialProgresiveNumber(value);

        for(int i = 1; i < 5; i++) {
            if(numeroPar.getValue() % 2 != 0) {
                System.out.println("El número elegido debe ser par");
                break;
            };
            System.out.println(numeroPar.returnProgresiveNumber(value));
        }

        numeroPar.resetProgresiveNumber();

        System.out.println("------------------------------------------------------");

        SerieImpar numeroImpar = new SerieImpar();
        numeroImpar.setInitialProgresiveNumber(3);

        for(int i = 0; i < 5; i++) {
            if(numeroImpar.getValue() % 2 == 0) {
                System.out.println("El número elegido debe ser par");
                break;
            }

            System.out.println(numeroImpar.returnProgresiveNumber(value));
        }

        numeroImpar.resetProgresiveNumber();

        System.out.println("------------------------------------------------------");
        SerieCustom numeroCustom = new SerieCustom();
        int numeroElegido = 4;
        numeroCustom.setInitialProgresiveNumber(numeroElegido);

        for(int i = 0; i < 5; i++) {
            System.out.println(numeroCustom.returnProgresiveNumber(numeroElegido));
        }

        numeroCustom.resetProgresiveNumber();

    }
}