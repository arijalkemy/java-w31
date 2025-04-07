package ejercicio2;

public interface Imprimible {
    static void imprimirDocumento(Documento documento) {
        documento.imprimir();
    }

    void imprimirTipoDoc();

}
