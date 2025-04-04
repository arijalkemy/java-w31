package org.example.clasesdos;

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
    public String imprimir(String identificacion) {
        return "cantidadPaginas: " + cantidadPaginas+" nombreAutor: "+nombreAutor+" titulo: "+titulo+" genero: "+genero;
    }
}
