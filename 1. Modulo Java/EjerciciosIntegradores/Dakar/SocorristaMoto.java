package EjerciciosIntegradores.Dakar;

public class SocorristaMoto implements Socorrista<Moto> {
    
    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo a una moto con patente: " + moto.getPatente());  
    }
}
