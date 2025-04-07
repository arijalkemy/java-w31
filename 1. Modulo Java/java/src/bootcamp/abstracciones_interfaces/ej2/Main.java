package bootcamp.abstracciones_interfaces.ej2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Pérez", Arrays.asList("Java", "Spring", "SQL"));
        LibroPDF libro = new LibroPDF("El Quijote", "Miguel de Cervantes", 500, "Novela");
        Informes informes = new Informes("Este es el contenido del informe.", 10, "Ana", "Carlos");

        Imprimible.imprimir(curriculum);
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informes);
    }
}
