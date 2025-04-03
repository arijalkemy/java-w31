package banco.clientes;

import java.math.BigDecimal;

public abstract class Cliente {

    private String nombreCompleto;
    private int edad;
    private BigDecimal saldo;

    public Cliente(String nombreCompleto, int edad, BigDecimal saldo) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
