package org.example.models;

public class Informe implements Documento {
    String texto;
    int cantidadPaginas;
    String nombreAutor;
    String nombreRevisor;

    public Informe(int cantidadPaginas, String nombreAutor, String nombreRevisor) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.nombreRevisor = nombreRevisor;
    }

    @Override
    public void imprimir() {
        System.out.println("texto: "+this.texto+"cantidadPaginas: "+this.cantidadPaginas+ " nombreAutor: "+this.nombreAutor+" nombreRevisor: "+this.nombreRevisor);
    }
}
