package ABSeINT_Banco;
public class Main {
    public static void main(String[] args) {
        Cliente ejecutivo = new Ejecutivo();
        Cliente basico = new Basico();
        Cliente cobrador = new Cobrador();

        // crear transacciones
        Ejecutivo.Transaccion deposito = new Deposito();
        Ejecutivo.Transaccion transferencia = new Transferencia();
        Ejecutivo.Transaccion consultaSaldo = new ConsultaSaldo();
        Ejecutivo.Transaccion pagoServicios = new PagoServicios();
        Ejecutivo.Transaccion retiroEfectivo = new RetiroEfectivo();

        // realizar transacciones
        System.out.println("Ejecutivo:");
        ejecutivo.realizarTransaccion(deposito); //  ok
        ejecutivo.realizarTransaccion(transferencia); //  ok
        ejecutivo.realizarTransaccion(pagoServicios); //  no ok

        System.out.println("\nBásico:");
        basico.realizarTransaccion(consultaSaldo); //  ok
        basico.realizarTransaccion(pagoServicios); //  ok
        basico.realizarTransaccion(deposito); //  no ok

        System.out.println("\nCobrador:");
        cobrador.realizarTransaccion(retiroEfectivo); //  ok
        cobrador.realizarTransaccion(consultaSaldo); //  ok
        cobrador.realizarTransaccion(transferencia); //  no ok
    }
}