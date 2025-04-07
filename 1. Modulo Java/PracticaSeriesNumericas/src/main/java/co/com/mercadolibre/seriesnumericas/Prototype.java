package co.com.mercadolibre.seriesnumericas;

public abstract class Prototype {

    private int currentNumberOfTHeSerie;
    private int numberToStartTheSerieWith;
    
    public Prototype() {
    }

    public Prototype(int currentNumberOfTHeSerie, int numberToStartTheSerieWith) {
        this.currentNumberOfTHeSerie = currentNumberOfTHeSerie;
        this.numberToStartTheSerieWith = numberToStartTheSerieWith;
    }

    public int getCurrentNumberOfTHeSerie() {
        return currentNumberOfTHeSerie;
    }

    public void setCurrentNumberOfTHeSerie(int currentNumberOfTHeSerie) {
        this.currentNumberOfTHeSerie = currentNumberOfTHeSerie;
    }

    public int getNumberToStartTheSerieWith() {
        return numberToStartTheSerieWith;
    }

    public void setNumberToStartTheSerieWith(int numberToStartTheSerieWith) {
        this.numberToStartTheSerieWith = numberToStartTheSerieWith;
    }

    public abstract Number devolverSiguienteValorDeSerieNumerica (Number number);
    public abstract Number reiniciarSerieNumerica (Number number);
    public abstract Number establecerValorInicialDeLaSerie (Number number);
}
