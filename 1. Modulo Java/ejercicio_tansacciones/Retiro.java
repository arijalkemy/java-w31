package E1;

public class Retiro implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro no realizado");
    }

    public Retiro() {
    }
}
