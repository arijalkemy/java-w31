package org.example.model;

public abstract class Prototipo<T extends Number> {

    private T inicioSerie;
    private T pasoEntreSerie;
    private T valorActual;

    public Prototipo(T inicioSerie, T pasoEntreSerie) {
        this.inicioSerie = inicioSerie;
        this.pasoEntreSerie = pasoEntreSerie;
        this.valorActual = this.inicioSerie;
    }

    public abstract void setPasoEntreSerie(T pasoEntreSerie);

    public abstract T siguienteNumero();

    public abstract void reiniciarSerie();

    public abstract void setInicioSerie(T inicioSerie);

}
