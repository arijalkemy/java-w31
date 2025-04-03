package com.mercadolibre.modulojava.interfacesdos;

public class LibrosPDF implements IImprimir {
    private int cantidadpaginas;
    private String nombreautor;
    private String titulo;
    private String genero;

    public LibrosPDF(int cantidadpaginas, String nombreautor, String titulo, String genero) {
        this.cantidadpaginas = cantidadpaginas;
        this.nombreautor = nombreautor;
        this.titulo = titulo;
        this.genero = genero;
    }
    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombreautor);
        System.out.println("Genero: " + genero);
        System.out.println("Titulo: " + titulo);
        System.out.println("cantidad de paginas: " + cantidadpaginas);
    }
}
