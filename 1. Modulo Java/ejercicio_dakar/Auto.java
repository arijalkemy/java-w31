package ejercicio_dakar;

public class Auto extends Vehiculo {

    public Auto(Double velicidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velicidad, aceleracion, anguloDeGiro, patente);
        ruedas = 4;
        peso = 1000.0;
    }

}
