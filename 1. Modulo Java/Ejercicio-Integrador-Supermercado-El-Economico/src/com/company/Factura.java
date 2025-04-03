package com.company;

import java.util.List;

public class Factura {
    private Cliente c;
    private List<Item> listaItems;
    private Double totalCompra;

    public Factura(Cliente c, List<Item> listaItems, Double totalCompra) {
        this.c = c;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "c=" + c +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
