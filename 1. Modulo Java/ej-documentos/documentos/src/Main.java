import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Jose", "Perez", Arrays.asList("SQL", "Java", "HTML"));
        Informe informe = new Informe("Este es un informe", 1, "Yo", "Ustedes");
        LibroEnPDF libro = new LibroEnPDF(2, "Libro JAVA", "Juan", "Programacion");

        Imprimible.imprimir(curriculum);
        Imprimible.imprimir(informe);
        Imprimible.imprimir(libro);
    }
}
