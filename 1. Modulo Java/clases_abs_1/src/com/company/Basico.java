package com.company;

public class Basico implements ConsultaSaldo, PagoServicios, RetiroEfectivo{

    @Override
    public Boolean transaccionOk() {
        System.out.println("La transaccion se realizó con exito" );
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("La transaccion no pudo realizarse" );
        return false;
    }


    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo.");
    }

    @Override
    public void pagarServicios(String servicio) {
        System.out.println("Pagando servicio: " + servicio);

    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo");

    }
}
