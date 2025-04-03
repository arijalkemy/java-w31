package ClasesAbstractaseInterfaces.P1.Ejercicio1;

public class Ejecutivo extends Cliente {
    public Ejecutivo(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public boolean realizarDeposito(double monto) {
        Deposito deposito = new Deposito(monto);
        deposito.realizarDeposito(this);
        return deposito.transaccionOk();
    }

    public boolean realizarTransferencia(double monto, Cliente cliente) {
        Transferencia transferencia = new Transferencia(monto, cliente);
        transferencia.realizarTransferencia(this, cliente);
        return transferencia.transaccionOk();
    }
    
}