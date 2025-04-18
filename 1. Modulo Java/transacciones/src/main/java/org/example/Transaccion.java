package org.example;

public abstract class Transaccion {
    public void transaccionOk() {
        System.out.println("transaccion realizada corractamente");
    }

    public void transccionNoOk() {
        System.out.println("transaccion no realizada corractamente");
    }

    public abstract void transaccion();
}
