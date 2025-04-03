package com.mercadolibre.agenciaDeViajes.model;

public class Reserva {
    private TipoReserva tipoReserva;
    private Double valor;

    public Reserva(TipoReserva tipoReserva, Double valor) {
        this.tipoReserva = tipoReserva;
        this.valor = valor;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public Double getValor() {
        return valor;
    }
}
