package documentos;

public class Programa {
    public static void main(String[] args) {
        // Crear diferentes documentos
        Documento informe = new Informe("Reporte Anual", "Juan Pérez", "01/04/2025", "Este es el contenido del informe.");
        Documento libro = new Libro("El Principito", "Antoine de Saint-Exupéry", "978-3-16-148410-0", 1943);
        Documento curriculum = new Curriculum("María", "González", "123456789", "maria@example.com", "Calle Falsa 123", "15/08/1990");

        // Imprimir los documentos en consola
        System.out.println("Imprimiendo documentos:");
        informe.imprimirEnConsola();
        libro.imprimirEnConsola();
        curriculum.imprimirEnConsola();
    }
}