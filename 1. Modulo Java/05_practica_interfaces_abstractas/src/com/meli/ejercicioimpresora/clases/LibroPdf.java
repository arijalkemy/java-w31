package com.meli.ejercicioimpresora.clases;

import com.meli.ejercicioimpresora.interfaces.Documento;

public class LibroPdf implements Documento {
    int cantidadPaginas;
    String nombreDeAutor;
    String titulo;
    String autor;

    @Override
    public void imprimir() {
        System.out.println("Paginas: " + cantidadPaginas + ". Autor: " + nombreDeAutor);
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreDeAutor() {
        return nombreDeAutor;
    }

    public void setNombreDeAutor(String nombreDeAutor) {
        this.nombreDeAutor = nombreDeAutor;
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

    public LibroPdf(int cantidadPaginas, String nombreDeAutor, String titulo, String autor) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreDeAutor = nombreDeAutor;
        this.titulo = titulo;
        this.autor = autor;
    }
}
