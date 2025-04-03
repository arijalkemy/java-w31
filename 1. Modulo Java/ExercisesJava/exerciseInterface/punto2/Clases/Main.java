package exerciseInterface.punto2.Clases;

import java.util.ArrayList;

import exerciseInterface.punto2.Interfaz.Imprimir;

public class Main {
    public static void main(String[] args) {

        // doc curriculum
        Curriculum curriculum = new Curriculum("Petunia", 1234, 24);
        curriculum.agregarhabilidad("trabajo en equipo ");
        curriculum.agregarhabilidad("arquitectura");
        curriculum.agregarhabilidad("responsabilidad");

        // doc libropdf
        LibroPdf libroPdf = new LibroPdf(45, "Gabo", "Cuentos para dormir", "literario");
        // doc informe
        Informes informes = new Informes("La realidad se impuso.", 56, " Oscar Wilde ", " Andres Torero ");

        // impresion
       Imprimir.imprimirDocumento(informes);
       Imprimir.imprimirDocumento(libroPdf);
       Imprimir.imprimirDocumento(curriculum);
       
    }
}
