package exerciseIntegrator2.exercise2.Interfaces;

import exerciseIntegrator2.exercise2.clases.Autos;


public interface SocorrerAuto extends Socorrer<Autos> {

    @Override
    default void socorrer(Autos vehiculo) {
        System.out.println("Socorriendo auto " + vehiculo.getPatente());

    }

}
