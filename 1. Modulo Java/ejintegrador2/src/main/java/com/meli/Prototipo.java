package com.meli;

public abstract class Prototipo {
    protected int valorInicial;
    // reiniciar
    public Prototipo(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract int devolverSiguiente();
        //devolver un número que corresponderá al valor siguiente a la serie progresiva.
        //int siguiente = valorInicial+contador;
        //contador+=3;
        //return valorInicial+contador;
    

    public int reiniciarSerie(int valorInicial){
        this.valorInicial = valorInicial;
        return this.valorInicial;
    }
    



    public int recibirValorInicial(int nuevoInicial){
        return this.valorInicial = nuevoInicial;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }
}