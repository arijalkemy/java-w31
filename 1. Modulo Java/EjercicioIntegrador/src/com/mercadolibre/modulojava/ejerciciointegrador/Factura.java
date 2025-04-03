package com.mercadolibre.modulojava.ejerciciointegrador;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double compratotal;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }
}
