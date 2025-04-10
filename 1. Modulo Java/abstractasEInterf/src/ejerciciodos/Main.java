package ejerciciodos;

import ejerciciodos.interfaces.MostrarDocumento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Java");
        habilidades.add("POO");

        Curriculum cv = new Curriculum("Lucas", "Vilas", habilidades);
        LibroPdf pdf = new LibroPdf(10, "Tesla.pdf", "Elon Musk", "Tesla", "Tecnologia");

        MostrarDocumento.mostrarDoc(cv);
        System.out.println();
        MostrarDocumento.mostrarDoc(pdf);

    }
}
