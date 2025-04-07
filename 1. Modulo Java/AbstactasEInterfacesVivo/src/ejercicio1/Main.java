package ejercicio1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear instancias de clientes
        Ejecutivo ejecutivo = new Ejecutivo();
        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();

        // Probar transacciones de Ejecutivo
        System.out.println("Ejecutivo:");
        ejecutivo.hacerDeposito(300.0);
        ejecutivo.hacerTransferencia();

        // Probar transacciones de Basico
        System.out.println("\nBasico:");
        basico.hacerConsultaSaldo();
        basico.hacerTransferencia();
        basico.hacerPagoServicio("Luz");

        // Probar transacciones de Cobrador
        System.out.println("\nCobrador:");
        cobrador.hacerTransferencia();
        cobrador.hacerConsultaSaldo();
        cobrador.hacerRetiroEfectivo(200.0);
    }
}