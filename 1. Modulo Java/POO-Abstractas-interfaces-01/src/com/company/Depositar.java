package com.company;

public class Depositar implements Transaccion{


    @Override
    public void transaccionOk() {
        System.out.println("Deposito Exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ocurrio un error al depositar");
    }
}
