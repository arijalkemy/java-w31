package org.example.models;

public class LibroPDF implements Documento {

    int cantidadPaginas;
    String nombreAutor;
    String titulo;
    String genero;

    public LibroPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("cantidadPaginas: " + cantidadPaginas+" nombreAutor: "+nombreAutor+" titulo: "+titulo+" genero: "+genero);
    }
}
