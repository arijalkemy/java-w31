package ejercicio_dakar;

public class Moto extends Vehiculo {

    public Moto(Double velicidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velicidad, aceleracion, anguloDeGiro, patente);
        ruedas = 2;
        peso = 300.0;
    }

}
