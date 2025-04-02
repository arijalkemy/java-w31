package clase.POO.tres.ejercicio2;

import clase.POO.tres.ejercicio2.Documentos.Curriculum;
import clase.POO.tres.ejercicio2.Documentos.Documento;
import clase.POO.tres.ejercicio2.Documentos.Informe;
import clase.POO.tres.ejercicio2.Documentos.LibroPDF;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<String> habilidades = new ArrayList<>();

    public static void main(String[] args) {
        //Impresion informe
        Documento informe = new Informe("informe",34,"Juan","Pedro");
        informe.imprimir();

        //Impresion curriculum
        habilidades.add("programacion");
        habilidades.add("trabajo en equipo");
        habilidades.add("estudios");

        Documento curriculum = new Curriculum("Juan", "Montes", "313131",habilidades );
        curriculum.imprimir();

        //Impresion libro pdf
        Documento libroPDF = new LibroPDF(34,"Pedro", "el ave que no volaba", "suspenso");
        libroPDF.imprimir();
    }
}
