package com.meli.ejercicioimpresora.clases;

import com.meli.ejercicioimpresora.interfaces.Documento;

public class Informe implements Documento {
    Integer longitud;
    Integer cantidadPaginas;
    String autor;
    String revisor;

    @Override
    public void imprimir() {
        System.out.println("Imprimo Informe");
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Integer getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(Integer cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informe(Integer longitud, Integer cantidadPaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }
}
