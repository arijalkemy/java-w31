package com.mercadolibre.modulojava.interfacesdos;

public interface IImprimir {
    public void imprimir();
    public static void imp(IImprimir imprimir){
        System.out.println("Documento");
        imprimir.imprimir();
        System.out.println();

    }

}
