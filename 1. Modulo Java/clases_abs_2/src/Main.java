import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Florencia", "Galindez",
                "Ingeniería Electrónica", Arrays.asList("Java","Spring"));

        LibroPDF libro = new LibroPDF(109,"J.K Rowling",
                "Harry Potter y la camara de los secretos", "Aventuras");

        Informes informe = new Informes("Nota...", 6,
                "Florencia Galindez", "Maximiliano Suarez");

        //Imprimir
        IImprimir.imprimir(cv);
        IImprimir.imprimir(libro);
        IImprimir.imprimir(informe);

    }
}