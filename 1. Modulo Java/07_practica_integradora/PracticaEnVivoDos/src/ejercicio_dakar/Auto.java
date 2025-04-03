package ejercicio_dakar;

public class Auto extends Vehiculo{
    public Auto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, 1000.0, 4, patente);
    }
}
