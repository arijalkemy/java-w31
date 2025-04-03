package com.meli.ejercicioimpresora;

import com.meli.ejercicioimpresora.clases.Curriculum;
import com.meli.ejercicioimpresora.clases.Impresora;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> habilidades = new ArrayList<>();
        habilidades.add("Programar");

        Curriculum curr = new Curriculum("Nico" , habilidades);
        Impresora.imprimir(curr);
    }

}
