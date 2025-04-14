package com.mercadoLibre;

import java.util.EnumSet;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private TipoReserva tipo;
    private double costo;
    private double total;

    public Localizador(Cliente cliente, TipoReserva tipo, double costo) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.costo = costo;
    }

    public void aplicarDescuento() {
        if (cliente.getNumeroLocalizadores() >= 2) {
            this.total = costo * 0.95;
        } else {
            this.total = costo;
        }

        if (tipo == TipoReserva.HOTEL || tipo == TipoReserva.BOLETO) {
            int numReservas = (int) cliente.getLocalizadores().stream()
                    .filter(l -> l.getTipo() == tipo).count();
            if (numReservas >= 2) {
                this.total = this.total * 0.95;
            }
        }

        if (cliente.getLocalizadores().stream()
                .map(Localizador::getTipo)
                .collect(Collectors.toSet())
                .containsAll(EnumSet.allOf(TipoReserva.class))) {
            this.total = this.total * 0.90;
        }
    }

    public void imprimirLocalizador() {
        System.out.println("Tipo: " + tipo + ", Costo: " + costo + ", Total: " + total);
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public double getTotal() {
        return total;
    }

}

