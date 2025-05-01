public interface Imprimir {
    void imprimir();

    static void imprimirDocumento(Imprimir documento) {
        documento.imprimir();
    }
}
