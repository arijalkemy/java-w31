package com.mercadolibre.modulojava.interfacesuno;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa");
    }
    @Override
    public  void transaccionNoOk(){
        System.out.println("Consulta de salgo fallida");
    }
}
