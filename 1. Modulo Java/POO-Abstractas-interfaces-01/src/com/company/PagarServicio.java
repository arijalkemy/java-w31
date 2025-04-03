package com.company;

public class PagarServicio implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de Servicio Exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ocurrio un error al Pagar el Servicio");
    }
}
