package clases;

public class SocorristaAuto extends Vehiculo{
    public SocorristaAuto(Integer velocidad, Integer aceleracion, Integer anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, 1000.0, 4);
    }

    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo auto");
        System.out.println("Patente: " + unAuto.getPatente());
    }
}
