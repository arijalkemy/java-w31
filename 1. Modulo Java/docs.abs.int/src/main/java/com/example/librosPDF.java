package com.example;

public class librosPDF implements imprimir {
    private String titulo;
    private String autor;
    private int cantidadPaginas;
    private String genero;

    public librosPDF(String titulo, String autor, int cantidadPaginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Informacion del libro:");
        System.out.println(titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Cantidad de paginas: " + cantidadPaginas);
        System.out.println("Genero: " + genero);
    }

}
