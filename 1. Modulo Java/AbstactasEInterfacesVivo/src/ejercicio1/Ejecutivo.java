package ejercicio1;

public class Ejecutivo implements Deposito, Transferencia{
    @Override
    public void hacerDeposito(Double montoDeposito) {
        System.out.println("Intentando hacer depósito de " + montoDeposito + "...");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Intentando hacer transferencia...");
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }
}
