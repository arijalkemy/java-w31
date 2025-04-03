public class Moto extends Vehiculo {

    public Moto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        peso = 300;
        ruedas = 2;
    }
}
