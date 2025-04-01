package org.example.imprimibles;

public class Informe implements Imprimible {
    private final String titulo;
    private final String autor;
    private final String revisor;
    private final String texto;

    public Informe(String titulo, String autor, String revisor, String texto) {
        this.titulo = titulo;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }


    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("-----------------------");
        System.out.println("Texto: " + texto);
    }
}
