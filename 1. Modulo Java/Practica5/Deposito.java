package Practica5;

public class Deposito implements Transaccion{



    @Override
    public void transaccionOk() {
        System.out.println("el deposito se ha realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("no se pudo realizar el deposito, por favor intente otra vez");
    }



}
