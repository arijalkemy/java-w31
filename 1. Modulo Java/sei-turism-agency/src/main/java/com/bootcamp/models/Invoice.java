package com.bootcamp.models;

import java.util.List;

public class Invoice {
    private Integer id;
    private Double totalPrice;
    private Client client;
    private List<Localizer> localizers;

    public Invoice(Integer id, Double totalPrice, Client client) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Client getClient() {
        return client;
    }

    public List<Localizer> getLocalizers() {
        return localizers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLocalizers(List<Localizer> localizers) {
        this.localizers = localizers;
    }
}
