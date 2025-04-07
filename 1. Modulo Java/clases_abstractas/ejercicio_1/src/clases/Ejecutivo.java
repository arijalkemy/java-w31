package clases;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia{
    private int saldo;
    private String cliente;
    public Ejecutivo(int saldo, String cliente){ this.saldo = saldo; this.cliente = cliente; };
    public int getSaldo(){
        return saldo;
    }
    @Override
    public void hacerDeposito(int monto) {
        try {
            final int transaccionId = (int) (Math.random() * 1000000);
            System.out.println("Depositando $" + monto);
            this.saldo += monto;
            this.transaccionOk(cliente, transaccionId, "deposito");
        } catch (Exception e) {
            this.transaccionNoOk("Deposito");
        }
    }
    @Override
    public void hacerTransferencia(int monto, Ejecutivo destino) {
        try {
            if (this.saldo < monto) {
                System.out.println("Fondos insuficientes para realizar la transferencia.");
                return;
            }
            final int transaccionId = (int)(Math.random() * 1000000);
            System.out.println("Realizando transferencia de $" + monto + " desde " + this.cliente + " hacia " + destino.cliente);
            this.saldo -= monto;
            destino.hacerDeposito(monto);
            this.transaccionOk(this.cliente, transaccionId, "transferencia");
        } catch (Exception e) {
            this.transaccionNoOk("transferencia");
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
        System.out.println("La transacción: " + tipoTransaccion + " no se pudo concluir.");
    }
}