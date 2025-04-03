package com.company;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Tranferencia Exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ocurrio un error al transferir");
    }
}
