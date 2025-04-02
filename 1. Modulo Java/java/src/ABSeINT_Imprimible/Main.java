package ABSeINT_Imprimible;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            // crear un curriculum
            List<String> habilidades = new ArrayList<>(Arrays.asList("Java", "Python", "Comunicaciones"));
            Curriculum curriculum = new Curriculum("Manuela", "Tonelli", "58 764 7A", "2216038047", habilidades);

            // crear un libro
            LibroPDF libro = new LibroPDF("Gabriel García", "Hábitos atómicos", "Novela", 200);

            // crear un informe
            Informe informe = new Informe("Maria Diaz", "Juan Sanchez", "Este es un informe de ejemplo", 5);

            // Imprimir documentos
            imprimirDocumento(curriculum);
            imprimirDocumento(libro);
            imprimirDocumento(informe);
        }

        public static void imprimirDocumento(Imprimible documento) {
            documento.imprimir();
        }
    }

