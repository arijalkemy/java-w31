package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.model.Prototipo;
import com.mercadolibre.bootcamp.model.SerieDeDos;
import com.mercadolibre.bootcamp.model.SerieDeTres;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Iniciando serie de dos");
        Prototipo serieDeDos = new SerieDeDos(0);
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println();
        System.out.println("Iniciando serie de Tres");
        Prototipo serieDeTres = new SerieDeTres(0);
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());

    }
}