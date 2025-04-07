package bootcamp.abstracciones_interfaces.ej2;

public interface Imprimible {
    static void imprimir(Imprimible documento) {
        System.out.println(documento.obtenerContenido());
    }

    String obtenerContenido();
}
