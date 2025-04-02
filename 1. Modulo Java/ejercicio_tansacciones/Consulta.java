package E1;

public class Consulta implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Tienes $1000 en tu cuenta");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo fallo");
    }

    public Consulta() {
    }

}
