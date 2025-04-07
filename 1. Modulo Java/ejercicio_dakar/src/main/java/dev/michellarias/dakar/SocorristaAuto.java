package dev.michellarias.dakar;

public class SocorristaAuto extends Auto{

    public SocorristaAuto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
    }

    public void socorrer(Auto unAuto) {
        System.out.printf("Socorriendo Auto: %s\n", unAuto.getPatente());
    }
}
