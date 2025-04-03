package com.mercadolibre.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> itens;
    private Double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarItem(Item item) {
        this.itens.add(item);
    }

    public void calcular() {
        total = 0.0;
        for (Item item : itens) {
            total += item.getCostoUnitario() * item.getCantidad();
        }
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
