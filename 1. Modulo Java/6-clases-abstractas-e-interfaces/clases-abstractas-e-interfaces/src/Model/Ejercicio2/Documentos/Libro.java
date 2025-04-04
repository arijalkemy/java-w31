package Model.Ejercicio2.Documentos;

import Model.Ejercicio2.Imprimible;

public class Libro implements Imprimible {
    private Integer cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    @Override
    public void imprimir() {
        System.out.println("Soy un Libro que implementa el metodo imprimir");
    }
}
