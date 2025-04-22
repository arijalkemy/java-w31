package org.example;

import org.example.models.Curriculum;
import org.example.models.Documento;
import org.example.models.Informe;
import org.example.models.LibroPDF;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Duran", "233223", "juan@gmail.com");
        curriculum.addHabilidad("PYTHON");
        curriculum.addHabilidad("JAVA");

        Informe informe= new Informe(100, "Jose", "Carlos");
        LibroPDF libroPDF = new LibroPDF(100, "Juan", "Aprendiendo JAVA", "Tecnologia");
        List<Documento> documentos = Arrays.asList(curriculum, libroPDF, informe);

        documentos.forEach(Main::imprimir);
    }

    public static void imprimir(Documento documento){
        documento.imprimir();
    }
}