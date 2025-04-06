public interface Imprimible {
    public static void imprimir(Documento documento) {
        System.out.println("Imprimiendo Documento....");
        System.out.println(documento.toString());
    }
}
