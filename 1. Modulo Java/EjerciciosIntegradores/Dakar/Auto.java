package EjerciciosIntegradores.Dakar;

public class Auto extends Vehiculo {

    public Auto(Long velocidad, Long aceleracion, Long anguloDeGiro, String patente, Integer peso, Integer cantRuedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, cantRuedas);
        this.setPeso(1000);
        this.setCantRuedas(4);
    }
}
