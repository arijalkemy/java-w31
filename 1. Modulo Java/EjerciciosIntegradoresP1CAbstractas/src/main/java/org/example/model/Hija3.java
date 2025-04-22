package org.example.model;

public class Hija3 extends Prototipo<Integer> {

    private Integer inicioSerie;
    private Integer pasoEntreSerie;
    private Integer valorActual;

    public Hija3() {
        super(0,1);
    }

    @Override
    public void setPasoEntreSerie(Integer pasoEntreSerie) {
        this.pasoEntreSerie = pasoEntreSerie;
    }

    @Override
    public Integer siguienteNumero(){
        return this.valorActual+=this.pasoEntreSerie;
    }


    @Override
    public void reiniciarSerie(){
        this.inicioSerie = 0;
        this.valorActual = this.inicioSerie;
    }

    @Override
    public void setInicioSerie(Integer inicioSerie) {
        this.inicioSerie = inicioSerie;
        this.valorActual = this.inicioSerie;
    }

}
