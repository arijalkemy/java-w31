package EjerciciosIntegradores.Dakar;

public class Moto extends Vehiculo{
    public Moto(Long velocidad, Long aceleracion, Long anguloDeGiro, String patente, Integer peso, Integer cantRuedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, cantRuedas);
        this.setPeso(300);
        this.setCantRuedas(2);
    }
}
