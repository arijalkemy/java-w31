package exerciseIntegrator2.exercise2.clases;

import exerciseIntegrator2.exercise2.Interfaces.SocorrerAuto;

public class Autos extends Vehiculo implements SocorrerAuto {

    public Autos(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso,
            Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
        setPeso(1000D);
        setRuedas(4);
    }

   

}
