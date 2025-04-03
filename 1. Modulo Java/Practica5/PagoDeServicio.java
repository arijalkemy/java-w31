package Practica5;

public class PagoDeServicio implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("el pago del servicio se ha realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("no se pudo realizar el pago del servicio, por favor intente otra vez");
    }
}
