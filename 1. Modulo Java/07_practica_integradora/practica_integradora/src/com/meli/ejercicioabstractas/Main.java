package com.meli.ejercicioabstractas;

import com.meli.ejercicioabstractas.clases.SucesionDos;
import com.meli.ejercicioabstractas.clases.SucesionTres;

public class Main {
    public static void main(String[] args) {
        SucesionDos suc = new SucesionDos();
        System.out.println(suc.sucesivo());
        System.out.println(suc.sucesivo());
        System.out.println(suc.sucesivo());

        suc.establecerInicio(2);
        System.out.println(suc.sucesivo());
        System.out.println(suc.sucesivo());

        SucesionTres sucesionTres = new SucesionTres();
        System.out.println(sucesionTres.sucesivo());
        System.out.println(sucesionTres.sucesivo());
        System.out.println(sucesionTres.sucesivo());
        System.out.println(sucesionTres.sucesivo());
        System.out.println(sucesionTres.sucesivo());
    }
}
