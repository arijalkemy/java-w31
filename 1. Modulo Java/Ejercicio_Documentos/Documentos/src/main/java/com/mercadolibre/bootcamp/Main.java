package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.interfaces.Imprimible;
import com.mercadolibre.bootcamp.model.Curriculum;
import com.mercadolibre.bootcamp.model.Informe;
import com.mercadolibre.bootcamp.model.LibroPDF;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Pérez", "001", Arrays.asList("Java", "Python", "Comunicación"));
        LibroPDF libroPDF = new LibroPDF("El Quijote", "Miguel de Cervantes", 500, "Novela");
        Informe informe = new Informe("Este es un informe importante.", 10, "Ana", "Luis");

        Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(libroPDF);
        Imprimible.imprimirDocumento(informe);
    }
}