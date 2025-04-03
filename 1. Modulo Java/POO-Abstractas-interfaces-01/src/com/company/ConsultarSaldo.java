package com.company;

public class ConsultarSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta Exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ocurrio un error al Consultar Saldo");
    }
}
