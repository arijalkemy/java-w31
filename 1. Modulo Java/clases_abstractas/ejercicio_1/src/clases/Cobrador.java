package clases;

import interfaces.Saldo;
import interfaces.Retiro;

public class Cobrador implements Saldo, Retiro {
    private int saldo;
    private String cliente;
    public Cobrador(int saldo, String cliente) { this.saldo = saldo; this.cliente = cliente; };
    
    public Cobrador(int saldo){ this.saldo = saldo; };

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