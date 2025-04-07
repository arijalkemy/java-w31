package bootcamp.abstracciones_interfaces.ej1;

import bootcamp.abstracciones_interfaces.ej1.interfaces.Deposito;
import bootcamp.abstracciones_interfaces.ej1.interfaces.Transaccion;
import bootcamp.abstracciones_interfaces.ej1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia, Transaccion {

    @Override
    public void hacerTransferencia() {
        System.out.println("Ejecutivo hace transferencia");
    }

    @Override
    public void hacerDeposito() {
        System.out.println("Ejecutivo hace deposito");
    }
}
