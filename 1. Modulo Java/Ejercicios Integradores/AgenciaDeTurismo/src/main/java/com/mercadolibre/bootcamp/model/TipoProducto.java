package com.mercadolibre.bootcamp.model;

public enum TipoProducto {

    COMIDA("Comida"),
    RESERVA_HOTEL("Reserva Hotel"),
    TRANSPORTE("Transporte"),
    BOLETOS_DE_VIAJE("Boletos de Viaje");

    private final String tipo;

    TipoProducto(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
}
