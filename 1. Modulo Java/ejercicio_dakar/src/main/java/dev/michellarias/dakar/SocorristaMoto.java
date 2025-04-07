package dev.michellarias.dakar;

public class SocorristaMoto extends Moto{


    public SocorristaMoto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
    }

    public void socorrer(Moto unaMoto){
        System.out.printf("Socorriendo Moto: %s\n", unaMoto.getPatente());
    }
}
