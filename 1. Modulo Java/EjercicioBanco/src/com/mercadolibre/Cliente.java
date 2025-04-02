package com.mercadolibre;

public abstract class Cliente {
    private Double saldoEnCuenta;

    public Cliente(Double saldoEnCuenta) {
        this.saldoEnCuenta = saldoEnCuenta;
    }

    public Double getSaldoEnCuenta() {
        return saldoEnCuenta;
    }

    public void setSaldoEnCuenta(Double saldoEnCuenta) {
        this.saldoEnCuenta = saldoEnCuenta;
    }
}
