public class Auto extends Vehiculo {

    public Auto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        peso = 1000;
        ruedas = 4;
    }

}
