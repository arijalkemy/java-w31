package Practica5;

public class RetiroDeEfectivo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("el Retiro de Efectivo se ha realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("no se pudo realizar el retiro de efectivo, por favor intente otra vez");
    }
}
