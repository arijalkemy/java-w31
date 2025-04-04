package Model.Ejercicio2.Documentos;

import Model.Ejercicio2.Imprimible;

public class Informe implements Imprimible {
    private String texto;
    private Integer cantidadDePaginas;
    private String autor;
    private String revisor;

    @Override
    public void imprimir() {
        System.out.println("Soy un Informe que implementa el metodo imprimir");
    }
}
