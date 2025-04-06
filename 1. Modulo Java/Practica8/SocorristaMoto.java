package Practica8;

public class SocorristaMoto extends Moto{
    public SocorristaMoto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
    }

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo a la moto!!! " + unaMoto.getPatente());
    }

    @Override
    public String toString() {
        return "SocorristaMoto{}" + super.toString();
    }
}
