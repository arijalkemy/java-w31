package clase.POO.cinco.ejercicio1;

abstract class Prototipo<T extends Number> {
    protected T valorInicial;
    protected T incremento;
    protected T valorActual;

    public Prototipo(T valorInicial, T incremento){
        this.valorInicial = valorInicial;
        this.incremento = incremento;
        this.valorActual = valorInicial;
    }

    public abstract T siguiente();

    public int devolverValorSiguiente(){
        return 0;
    }
    public void reiniciarSerie(){
        this.valorActual = this.valorInicial;
    }

    public void reiniciarSerie(T valor){
        this.valorActual = valor;
        this.reiniciarSerie();
    }
}
