package bootcamp.abstracciones_interfaces.ej1;

public class Main {
    public static void main(String[] args) {

        Basic basico = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();
        basico.transaccionOk();
        basico.transaccionNoOk();

        ejecutivo.hacerTransferencia();

        cobrador.hacerRetiro(100);
    }
}
