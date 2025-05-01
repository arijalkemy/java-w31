public class Banco {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();

        System.out.println("Ejecutivo:");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        System.out.println("\nBásico:");
        basico.consultarSaldo();
        basico.pagarServicios();
        basico.retirarEfectivo();

        System.out.println("\nCobrador:");
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();
    }
}