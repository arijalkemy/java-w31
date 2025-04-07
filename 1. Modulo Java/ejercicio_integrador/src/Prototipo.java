package src;
public class Prototipo {
    int valor;
    int serie;
    int valorInicial = valor;
    int serieInicial = serie;

    public Prototipo(int valor, int serie) { this.valor = valor; this.serie = serie;};
    public int getValor() {
        this.valor = valor + serie;
        return valor;
    }
    public void resetSerie() {
        this.serie = serieInicial;
    }
    public void resetValor() {
        this.valor = valorInicial;
    }
}