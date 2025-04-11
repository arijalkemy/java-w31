package com.meli;

public interface transaccion {

    void ejecutar();
    default void transaccionOk() {
        System.out.println("Transacción realizada con éxito.");
    }
    default void transaccionNoOk() {
        System.out.println("Error en la transacción.");
    }
}


