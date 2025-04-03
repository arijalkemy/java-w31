package Practica5;

public class Transferencia implements Transaccion{


    @Override
    public void transaccionOk() {
        System.out.println("la trasnferencia se ha realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("no se pudo realizar la trasnferencia, por favor intente otra vez");
    }


}
