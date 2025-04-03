package banco.transacciones;

import java.math.BigDecimal;

import banco.clientes.Cliente;

public class Deposito implements Transaccion {

    public void hacerDeposito(BigDecimal monto, Cliente cliente) {
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            cliente.setSaldo(cliente.getSaldo().add(monto));
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Depósito exitoso. Su dinero ha sido depositado.");
    }

    @Override
    public void transaccionNoOk() {
        throw new RuntimeException("Depósito fallido. No se pudo completar la transacción.");
    }
}
