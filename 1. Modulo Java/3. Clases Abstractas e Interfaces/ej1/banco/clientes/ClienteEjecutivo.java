package banco.clientes;

import java.math.BigDecimal;

import banco.transacciones.Deposito;
import banco.transacciones.Transferencia;

public class ClienteEjecutivo extends Cliente {

    public ClienteEjecutivo(String nombreCompleto, int edad, BigDecimal saldo) {
        super(nombreCompleto, edad, saldo);
    }

    public void hacerDeposito(BigDecimal monto) {
        Deposito deposito = new Deposito();
        deposito.hacerDeposito(monto, this);
    }

    public void hacerTransferencia(BigDecimal montoTransferir, Cliente destino) {
        Transferencia transferencia = new Transferencia();
        transferencia.hacerTransferencia(montoTransferir, this, destino);
    }
}
