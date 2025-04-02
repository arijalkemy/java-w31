package com.mercadolibre;

public abstract class Transaccion implements Transaccionable{
    Cliente cliente;

    public Transaccion(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String transaccionOk() {
        String mensaje = "La transacción se realizó con exito";
        return mensaje;
    }

    @Override
    public String transaccionNoOk() {
        String mensaje = "La transacción no se realizó";
        return mensaje;
    }
}
