package banco.transacciones;

import java.math.BigDecimal;

import banco.clientes.Cliente;

public class RetiroEfectivo implements Transaccion {

    public void retirarEfectivo(BigDecimal monto, Cliente cliente) {
        if (cliente.getSaldo().compareTo(monto) < 0) {
            transaccionNoOk();
        }
        cliente.setSaldo(cliente.getSaldo().subtract(monto));
        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo exitoso. Su dinero ha sido dispensado.");
    }

    @Override
    public void transaccionNoOk() {
        throw new RuntimeException("Saldo insuficiente para realizar el retiro.");
    }
}
