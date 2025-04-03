package exerciseIntegrator2.exercise2.Interfaces;

import exerciseIntegrator2.exercise2.clases.Vehiculo;

public interface Socorrer<T extends Vehiculo> {
    void socorrer(T vehiculo);
}
