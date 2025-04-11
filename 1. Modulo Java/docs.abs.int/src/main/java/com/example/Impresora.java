package com.example;

public class Impresora {
    public static void imprimirDocumento(imprimir documento) {
        System.out.println("\n--- Imprimiendo documento ---");
        documento.imprimir();
        System.out.println("------------------------------\n");
    }
}