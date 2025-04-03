package com.company;

public class RetiroEnEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro Exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ocurrio un error al Retirar");
    }
}
