package com.mercadolibre.model;

public enum TipoProducto {
    HOTEL("Hotel"),
    COMIDA("Comida"),
    BOLETO_DE_VIAJE("Boleto de viaje"),
    TRANSPORTE("Transporte");

    private String tipo;

    TipoProducto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
