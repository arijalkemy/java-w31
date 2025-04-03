package ejerciciodos;

public class Main {
    public static void main(String[] args) {
        IImprimible curriculum = new Curriculum("Juan", "Pérez", 30, new String[]{"Java", "Python", "SQL"});
        IImprimible libroPDF = new LibroPDF("Gabriel García Márquez", "Cien Años de Soledad", "Realismo Mágico", 400);
        IImprimible informe = new Informe("Este es el contenido del informe.", "Ana Gómez", "Luis López", 10);

        imprimirDocumento(curriculum);
        imprimirDocumento(libroPDF);
        imprimirDocumento(informe);
    }

    private static void imprimirDocumento(IImprimible documento) {
        documento.imprimir();
        System.out.println();
    }
}
