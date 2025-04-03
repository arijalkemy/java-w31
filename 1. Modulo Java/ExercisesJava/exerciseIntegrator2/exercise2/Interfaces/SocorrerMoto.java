package exerciseIntegrator2.exercise2.Interfaces;


import exerciseIntegrator2.exercise2.clases.Motos;

public interface SocorrerMoto extends Socorrer<Motos> {

    @Override
    default void socorrer(Motos vehiculo) {
        System.out.println("Socorriendo moto " + vehiculo.getPatente());

    }
}
