package com.company;

public class Main {

    public static void main(String[] args) {
        Prototipo serieDeDos = new SerieDeDos(2);

        serieDeDos.reiniciar();
        serieDeDos.valorInicial(2);
        System.out.println(serieDeDos.valorSiguiente());
        System.out.println(serieDeDos.valorSiguiente());
        System.out.println(serieDeDos.valorSiguiente());
        System.out.println(serieDeDos.valorSiguiente());
        serieDeDos.valorInicial(1);
        System.out.println(serieDeDos.valorSiguiente());
        System.out.println(serieDeDos.valorSiguiente());
        System.out.println(serieDeDos.valorSiguiente());
        System.out.println(serieDeDos.valorSiguiente());

        Prototipo serieDeTres = new SerieDeTres(3);
        serieDeTres.reiniciar();
        serieDeTres.valorInicial(1);
        System.out.println(serieDeTres.valorSiguiente());
        System.out.println(serieDeTres.valorSiguiente());
        System.out.println(serieDeTres.valorSiguiente());
        System.out.println(serieDeTres.valorSiguiente());
    }
}
