package com.mercadolibre.modulojava.interfacesdos;

public class Informes implements IImprimir {
    private String texto;
    private int cantidadpaginas;
    private String nombreautor;
    private String revisor;

    public Informes(String texto, int cantidadpaginas, String nombreautor, String revisor) {
        this.texto = texto;
        this.cantidadpaginas = cantidadpaginas;
        this.nombreautor = nombreautor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Texto: " + texto);
        System.out.println("Cantidad de paginas: " + cantidadpaginas);
        System.out.println("Nombre autor: " + nombreautor);
        System.out.println("Revisor: " + revisor);
    }
}
