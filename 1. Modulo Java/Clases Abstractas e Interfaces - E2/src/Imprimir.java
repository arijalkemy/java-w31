public interface Imprimir {
    static void imprimir(Imprimir info) {
        info.imprimirContenido();
    }

    void imprimirContenido();
}
