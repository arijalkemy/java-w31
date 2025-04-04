package org.example.clasesdos;

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
    public String imprimir(String identificacion) {
        return "texto: "+this.texto+"cantidadPaginas: "+this.cantidadPaginas+ " nombreAutor: "+this.nombreAutor+" nombreRevisor: "+this.nombreRevisor;
    }
}
