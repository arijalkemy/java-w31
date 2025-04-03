package Practica5;

public class ConsultaDeSaldo implements Transaccion{


    @Override
    public void transaccionOk() {
        System.out.println("la consulta de saldo ha salido con exito, su saldo es 99999");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("no se pudo realizar la consulta, por favor intente otra vez");
    }
}
