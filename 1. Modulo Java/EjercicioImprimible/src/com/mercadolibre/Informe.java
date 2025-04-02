package com.mercadolibre;

public class Informe implements Imprimible{
    /* Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.*/
    private String texto;
    private Integer cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, Integer cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    @Override
    public String imprimir() {
        String imprimible = "Texto: " + this.texto + ", Cantidad de páginas: " + this.cantidadPaginas +
                ", Autor: " + this.autor + ", Revisor: " + this.revisor;
        return imprimible;
    }
}
