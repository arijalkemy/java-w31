package com.mercadolibre.bootcamp.model;

public interface Socorrista<T extends  Vehiculo> {


    void socorrer(T vehiculo);
}
