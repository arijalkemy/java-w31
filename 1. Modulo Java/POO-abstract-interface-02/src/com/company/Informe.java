package com.company;



public class Informe implements ImprimirDocumento{
    private String texto,autor, revisor;
    private Integer catidadDePaginas;

    public Informe(String texto, Integer catidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.catidadDePaginas = catidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getCatidadDePaginas() {
        return catidadDePaginas;
    }

    public void setCatidadDePaginas(Integer catidadDePaginas) {
        this.catidadDePaginas = catidadDePaginas;
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
    public void imprimirDocumento() {
        System.out.println("Informe{" +
                "texto='" + texto + '\'' +
                ", catidadDePaginas='" + catidadDePaginas + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}');
    }
}
