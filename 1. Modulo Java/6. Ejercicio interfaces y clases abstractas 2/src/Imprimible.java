interface Imprimible {
    static void imprimirDocumento(Imprimible documento) {
        System.out.println(documento.toString());
    }
}
