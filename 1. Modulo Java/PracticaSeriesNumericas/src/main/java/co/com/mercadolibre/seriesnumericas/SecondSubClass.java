package co.com.mercadolibre.seriesnumericas;

public class SecondSubClass extends Prototype {
    
    private int increment = 0;
    
    @Override
    public Number establecerValorInicialDeLaSerie(Number n) {
        increment = n.intValue();
        setCurrentNumberOfTHeSerie(0);
        return n;
    }

    @Override
    public Number devolverSiguienteValorDeSerieNumerica(Number n) {
        int nuevoValor = getCurrentNumberOfTHeSerie() + increment;
        setCurrentNumberOfTHeSerie(nuevoValor);
        return nuevoValor;
    }

    @Override
    public Number reiniciarSerieNumerica(Number n) {
        setCurrentNumberOfTHeSerie(n.intValue());
        return getCurrentNumberOfTHeSerie();
    }
}