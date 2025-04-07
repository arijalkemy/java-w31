package clases;

import interfaces.Pagos;
import interfaces.Retiro;
import interfaces.Saldo;


public class Basic implements Saldo, Pagos, Retiro {
    private int saldo;
    private String cliente;
    public Basic(int saldo, String cliente) { this.saldo = saldo ; this.cliente = cliente; };
    @Override
    public void consultaSaldo() {
        try {
            final int transaccionId = (int) (Math.random() * 1000000);

            System.out.println("consultando saldo...");
            System.out.println("El cliente tiene $" + saldo + " en cuenta.");
            this.transaccionOk(cliente, transaccionId, "consulta saldo");
        } catch (Exception e) {
            this.transaccionNoOk("Consulta");
        }
    }
    @Override
    public void hacerPago(String servicio, int cantidad){
        try {
            final int transaccionId = (int) (Math.random() * 1000000);
            System.out.println("Pagando servicio: " + servicio);
            saldo = saldo - cantidad;
            System.out.println("Resta en saldo: $" + saldo);
            this.transaccionOk(cliente, transaccionId, servicio);
        } catch (Exception e) {
            this.transaccionNoOk(servicio);
        }
    }
    @Override
    public void hacerRetiro(double monto){
        try {
            final int transaccionId = (int) (Math.random() * 1000000);

            System.out.println("Retirando $" + (int) monto + " en efectivo...");
            saldo = saldo - (int) monto;
            this.transaccionOk(cliente, transaccionId, "retiro de efectivo.");
            
        } catch (Exception e) {
            this.transaccionNoOk("Retiro");
        }
    }
    @Override
    public void transaccionOk(String cliente, int transaccion) {
        System.out.println( transaccion + " realizada correctamente.");
    }
    @Override
    public void transaccionOk(String cliente, int transaccion, String servicio) {
        System.out.println("Transaccion #" + transaccion + " realizada correctamente para cliente " + cliente + " al servicio: " + servicio + ".");
    }
    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción " + tipoTransaccion + " no se pudo concluir.");
    }
}