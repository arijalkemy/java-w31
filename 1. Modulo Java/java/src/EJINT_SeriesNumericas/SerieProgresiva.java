package EJINT_SeriesNumericas;

// clase prototipo que maneja la serie progresiva
class SerieProgresiva<T extends Number> {
    protected T valorInicial;
    protected T incremento;
    protected int contador;

    // Constructor
    public SerieProgresiva(T incremento) {
        this.incremento = incremento;
        this.contador = 0;
        this.valorInicial = (T) Integer.valueOf(0);
    }

    // obtener el siguiente valor
    public T siguienteValor() {
        contador++;
        return (T) Integer.valueOf(valorInicial.intValue() + (incremento.intValue() * contador));
    }

    // reiniciar la serie
    public void reiniciar() {
        contador = 0;
    }

    // establecer el valor inicial
    public void establecerValorInicial(T valor) {
        this.valorInicial = valor;
        this.contador = 0;
    }
}
