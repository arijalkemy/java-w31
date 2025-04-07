package ejercicio2;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de documentos
        Curriculum curriculum = new Curriculum("Juan", "Perez", "12345678", 30);
        curriculum.agregarHabilidad("Java");
        curriculum.agregarHabilidad("Spring");

        LibroPdf libroPdf = new LibroPdf("Ficción", 300, "Gabriel García Márquez", "Cien Años de Soledad");

        Informe informe = new Informe("Este es el texto del informe.", 10, "Ana Gomez", "Carlos Lopez");

        // Imprimir documentos
        System.out.println("Imprimiendo Curriculum:");
        Imprimible.imprimirDocumento(curriculum);
        //debe imprimir lo mismo, pero con la interfaz
        //podemos tratar a todos como imprimibles
        curriculum.imprimir();

        System.out.println("\nImprimiendo Libro PDF:");
        Imprimible.imprimirDocumento(libroPdf);

        System.out.println("\nImprimiendo Informe:");
        Imprimible.imprimirDocumento(informe);
    }
}