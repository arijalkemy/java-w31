package com.mercadolibre;

public class Main {
    public static void main(String[] args) {
        SerieEntera serieDe2 = new SerieEntera(0, 2);
        System.out.println(serieDe2.valorSiguiente());
        System.out.println(serieDe2.valorSiguiente());
        System.out.println(serieDe2.valorSiguiente());
        System.out.println(serieDe2.valorSiguiente());

        System.out.println("Reiniciando...");
        serieDe2.reiniciarSerie();
        System.out.println(serieDe2.valorSiguiente());
        System.out.println(serieDe2.valorSiguiente());

        System.out.println("\nSerie con decimales:");
        SerieDecimal serieDecimal = new SerieDecimal(0.5, 1.5);
        System.out.println(serieDecimal.valorSiguiente());
        System.out.println(serieDecimal.valorSiguiente());

        // Prueba cambiar valor inicial
        serieDe2.establecerValorInicial(1);
        System.out.println(serieDe2.valorSiguiente());
        System.out.println(serieDe2.valorSiguiente());
        System.out.println(serieDe2.valorSiguiente());
        System.out.println(serieDe2.valorSiguiente());
    }
}
