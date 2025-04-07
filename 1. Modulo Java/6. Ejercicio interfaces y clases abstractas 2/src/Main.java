import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan Perez", 30, Arrays.asList("Java", "Python", "Git"));
        LibroPDF libroPDF = new LibroPDF("Gabriel García Márquez", "Cien años de soledad", "Realismo Mágico", 417);
        Informe informe = new Informe("Este es el contenido del informe.", 15, "Maria Gomez", "Laura Martinez");

        Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(libroPDF);
        Imprimible.imprimirDocumento(informe);
    }
}