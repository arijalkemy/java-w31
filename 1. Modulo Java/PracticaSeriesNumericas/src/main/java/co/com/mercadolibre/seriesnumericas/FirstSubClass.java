package co.com.mercadolibre.seriesnumericas;

public class FirstSubClass extends Prototype {
    
    private final int INCREMENT = 2;
    
    @Override
    public Number devolverSiguienteValorDeSerieNumerica(Number n) {
        int nuevoValor = getNumberToStartTheSerieWith() + INCREMENT;
        setNumberToStartTheSerieWith(nuevoValor);
        return nuevoValor;
    }

    @Override
    public Number reiniciarSerieNumerica(Number n) {
        setNumberToStartTheSerieWith(n.intValue());
        return getNumberToStartTheSerieWith();
    }

    @Override
    public Number establecerValorInicialDeLaSerie(Number n) {
        setNumberToStartTheSerieWith(n.intValue());
        return getNumberToStartTheSerieWith();
    }
}