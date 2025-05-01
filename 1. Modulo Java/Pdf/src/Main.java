import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Juan", "Pérez", List.of("Java", "SQL", "Spring"));
        LibroPdf libro = new LibroPdf("El arte de programar", "Donald Knuth", 500, "Tecnología");
        Informe informe = new Informe("Este es un informe técnico...", 10, "Ana López", "Carlos Gómez");


        Imprimir.imprimirDocumento(cv);
        System.out.println("----------------------");
        Imprimir.imprimirDocumento(libro);
        System.out.println("----------------------");
        Imprimir.imprimirDocumento(informe);
    }
}
