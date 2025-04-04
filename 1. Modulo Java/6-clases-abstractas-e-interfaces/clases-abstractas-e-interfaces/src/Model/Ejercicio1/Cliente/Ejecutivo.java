package Model.Ejercicio1.Cliente;

import Model.Ejercicio1.Transacciones.Deposito;
import Model.Ejercicio1.Transacciones.Transferencia;

public class Ejecutivo extends Cliente implements Transferencia, Deposito {
    @Override
    public void hacerDeposito() {
        System.out.println("Soy un Cliente Ejecutivo que implementa el metodo hacerDeposito");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Soy un Cliente Ejecutivo que implementa el metodo hacerTransferencia");
    }

    @Override
    public Boolean transaccionOk() {
        return null;
    }

    @Override
    public Boolean transaccionNoOk() {
        return null;
    }
}
