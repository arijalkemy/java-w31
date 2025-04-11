package com.meli;

public class Operacion implements transaccion {
    public void deposito() {
        System.out.println("Realizando depósito...");
        transaccionOk();
    }

    public void transferencia() {
        System.out.println("Realizando transferencia...");
        transaccionOk();
    }

    public void retiro() {
        System.out.println("Realizando retiro de efectivo...");
        transaccionOk();
    }

    public void consulta() {
        System.out.println("Consultando saldo...");
        transaccionOk();
    }

    public void pago() {
        System.out.println("Realizando pago de servicios...");
        transaccionNoOk();
    }

    public void transaccionOk() {
        System.out.println("Transacción realizada con éxito.");
    }

    public void transaccionNoOk() {
        System.out.println("Error en la transacción.");
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}