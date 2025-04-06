package Practica8;

public class SocorristaAuto extends Auto{
    public SocorristaAuto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
    }
    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo al auto!!! " + unAuto.getPatente());
    }

    @Override
    public String toString() {
        return "SocorristaAuto{}" + super.toString();
    }
}
