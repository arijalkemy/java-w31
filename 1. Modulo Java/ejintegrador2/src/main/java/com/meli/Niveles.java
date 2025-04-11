package com.meli;


public class Niveles extends Prototipo {
// esto es un constructor super para que herede el valor de nivel
    public Niveles(int nivel) {
        super(nivel);
        
    }
    @Override
    public int devolverSiguiente() {
        return valorInicial++;
    }


}
