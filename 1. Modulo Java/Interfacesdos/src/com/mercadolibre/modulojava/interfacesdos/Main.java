package com.mercadolibre.modulojava.interfacesdos;

import java.util.ArrayList;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("java");
        habilidades.add("python");
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    Curriculums jorge= new Curriculums("Jorge Ignazio","10082842834","3204343020","junir@gmail.com",habilidades);
    IImprimir.imp(jorge);
    LibrosPDF misery= new LibrosPDF(344,"Stephen King","Misery","terror");
    IImprimir.imp(misery);
    Informes diego= new Informes("este es un informe",15,"Diego Mojica","Peña");
    IImprimir.imp(diego);
    }

}