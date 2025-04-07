//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();

        System.out.println("Transacciones del cliente Ejecutivo:");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        System.out.println("\nTransacciones del cliente Basico:");
        basico.realizarRetiro();
        basico.realizarConsultaSaldo();
        basico.realizarPagoServicio();

        System.out.println("\nTransacciones del cliente Cobrador:");
        cobrador.realizarRetiro();
        cobrador.realizarConsultaSaldo();
    }
}