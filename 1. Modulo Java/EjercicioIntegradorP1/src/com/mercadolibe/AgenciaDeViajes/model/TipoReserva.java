package com.mercadolibe.AgenciaDeViajes.model;

public enum TipoReserva {
    HOTEL,
    COMIDA,
    BOLETO,
    TRANSPORTE;

    public static TipoReserva fromString(String tipo) {
        switch (tipo.toUpperCase()) {
            case "HOTEL":
                return HOTEL;
            case "COMIDA":
                return COMIDA;
            case "BOLETO":
                return BOLETO;
            case "TRANSPORTE":
                return TRANSPORTE;
            default:
                throw new IllegalArgumentException("Tipo de reserva no válido: " + tipo);
        }
    }
}
