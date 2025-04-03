package exerciseIntegrator2.exercise2.clases;

import exerciseIntegrator2.exercise2.Interfaces.SocorrerMoto;

public class Motos extends Vehiculo implements SocorrerMoto{

    public Motos(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso,
            Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
       setPeso(300D);
       setRuedas(2);
    }

}
