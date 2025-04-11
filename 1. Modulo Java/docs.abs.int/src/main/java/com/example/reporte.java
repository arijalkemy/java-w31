package com.example;

public class reporte implements imprimir {
    private String textoN;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public reporte(String textoN, int cantidadPaginas, String autor, String revisor) {
        this.textoN = textoN;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTextoN() {
        return textoN;
    }

    public void setTextoN(String textoN) {
        this.textoN = textoN;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
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

    @Override
    public void imprimir() {
        System.out.println("Reporte:");
        System.out.println("Cantidad de paginas: " + cantidadPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println(textoN);
        
    }

}
