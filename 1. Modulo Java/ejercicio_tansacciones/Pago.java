package ejercicio_tansacciones;

public class Pago implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios no realizado");
    }

    public Pago() {
    }

}
