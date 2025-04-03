package EjerciciosIntegradores.Dakar;

public class SocorristaAuto implements Socorrista<Auto> {
    
    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo a un auto con patente: " + auto.getPatente());
    }
}
