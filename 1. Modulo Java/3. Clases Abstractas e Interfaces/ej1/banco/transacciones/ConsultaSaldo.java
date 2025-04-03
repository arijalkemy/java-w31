package banco.transacciones;

import java.math.BigDecimal;

import banco.clientes.Cliente;

public class ConsultaSaldo implements Transaccion {

    public void consultarSaldo(Cliente cliente) {
        BigDecimal saldo = cliente.getSaldo();
        if (saldo.compareTo(BigDecimal.ZERO) >= 0) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        throw new RuntimeException("No se pudo acceder a la información de saldo.");
    }
}
