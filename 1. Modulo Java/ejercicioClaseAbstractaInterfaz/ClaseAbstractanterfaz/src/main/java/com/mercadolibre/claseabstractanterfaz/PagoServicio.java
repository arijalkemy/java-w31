package main.java;

public class PagoServicio implements Transaccion{
    @Override
    public boolean transaccionOk() {
        System.out.println("Se pago servicio");
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        System.out.println("No se pago servicio");
        return false;
    }
}
