package com.meli;

public class Main {
    public static void main(String[] args) {
        
        Niveles nivel1 = new Niveles(1);
        System.out.println("Niveles:");
        System.out.println("- "+nivel1.devolverSiguiente());
        System.out.println("  - "+nivel1.devolverSiguiente());
        System.out.println("    - "+nivel1.devolverSiguiente());
        nivel1.reiniciarSerie(4);
        System.out.println("Avanzaste al nivel: "+nivel1.devolverSiguiente());
        System.out.println();

        
        // Los EXPs se duplican x2 con valor inicial de 200
        Exps exp1 = new Exps(200);
        System.out.println("Exps: " +exp1);
        System.out.println("Próximo a desbloquear:");
        System.out.println("°"+exp1.devolverSiguiente());
        System.out.println("°"+exp1.devolverSiguiente());
        System.out.println("°"+exp1.devolverSiguiente());
        System.out.println("°"+exp1.devolverSiguiente());
    }
}