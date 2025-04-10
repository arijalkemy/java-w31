package clases;

public class SocorristaMoto extends Vehiculo{
    public SocorristaMoto(Integer velocidad, Integer aceleracion, Integer anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, 300.0, 2);
    }

    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo moto");
        System.out.println("Patente: " + unaMoto.getPatente());
    }
}
