package com.company;

public class Main {

    public static void main(String[] args) {
        Persona p = new Persona("Miguel","38.220.103");
        Curriculum c = new Curriculum(p,new String[]{"Hablar","Correr","Programar"});
        c.imprimirDocumento();
        LlamarImprimir.imprimir(c);

        LibroEnPdf l = new LibroEnPdf(250,"Pedro","Aprediendo algo","Comedia");
        l.imprimirDocumento();
        LlamarImprimir.imprimir(l);

        Informe i = new Informe("Informe Semanal",24,"Miguel","Jose");
        i.imprimirDocumento();
        LlamarImprimir.imprimir(i);


    }
}
