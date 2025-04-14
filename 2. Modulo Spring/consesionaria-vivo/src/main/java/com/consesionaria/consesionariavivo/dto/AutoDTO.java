package com.consesionaria.consesionariavivo.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class AutoDTO implements Serializable {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<ServiciesDTO> servicies;
    private String countOfOwners;

    public AutoDTO() {
    }

    public AutoDTO(String brand, String model, String manufacturingDate, String numberOfKilometers,
                   String doors, String price, String currency, List<ServiciesDTO> servicies, String countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.servicies = servicies;
        this.countOfOwners = countOfOwners;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(String numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<ServiciesDTO> getServicies() {
        return servicies;
    }

    public void setServicies(List<ServiciesDTO> servicies) {
        this.servicies = servicies;
    }

    public String getCountOfOwners() {
        return countOfOwners;
    }

    public void setCountOfOwners(String countOfOwners) {
        this.countOfOwners = countOfOwners;
    }
}
