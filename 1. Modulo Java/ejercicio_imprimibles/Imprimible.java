package ejercicio_imprimibles;

public interface Imprimible {

    static void imprimir(Imprimible impresion) {
        System.out.println(impresion);
    }
}