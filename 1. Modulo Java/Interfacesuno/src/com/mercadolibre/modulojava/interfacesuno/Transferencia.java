package com.mercadolibre.modulojava.interfacesuno;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia exitosa");
    }
    @Override
    public  void transaccionNoOk(){
        System.out.println("Transferencia fallida");
    }
}
