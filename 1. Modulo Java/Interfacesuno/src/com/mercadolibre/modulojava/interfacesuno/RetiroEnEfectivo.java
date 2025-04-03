package com.mercadolibre.modulojava.interfacesuno;

public class RetiroEnEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro en efectivo exitoso");
    }
    @Override
    public void transaccionNoOk(){
        System.out.println("Retiro en efectivo fallido");
    }
}
