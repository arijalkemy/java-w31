package seriesabstractas;

public class SerieDeTres extends Prototipo<Integer> {

    public SerieDeTres(int valorActual, int progresion) {
        super(valorActual, progresion);

    }

    @Override
    public void resetSeries() {
        System.out.println("Reseteando la serie a 0");
        super.setValorActual(0);

    }

    @Override
    public Integer suma(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }
}
