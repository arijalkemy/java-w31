public interface Imprimible {
    
    static void imprimirDoc(Documento documento) {
        documento.imprimir();
    }
    void imprimirTipoDoc();
}
