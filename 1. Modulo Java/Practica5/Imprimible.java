package Practica5;

public interface Imprimible {

    public static void imprimirDocumento(Imprimible documento){
        documento.imprimir();
    }
    public void imprimir();
}
