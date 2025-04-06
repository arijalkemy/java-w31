package com.bootcamp.models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String dni;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Integer> localizerIds = new ArrayList<>();
    private Double discount;

    public Client(String dni, String firstName, String lastName, String phoneNumber) {
        System.out.println("\nClient created");
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        System.out.println(this);
    }

    public String getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Integer> getLocalizerIds() {
        return localizerIds;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addLocalizerId(Integer localizerId) {
        System.out.println("\nAdding localizer with id: " + localizerId + " to client: " + this.firstName);
        this.localizerIds.add(localizerId);
        calculateDiscount();
    }

    public void calculateDiscount() {
        if (localizerIds != null) {
            if (localizerIds.size() >= 2){
                this.discount = 0.05;
            } else {
                this.discount = 0.0;
            }
        }
    }

    @Override
    public String toString() {
        return "\n\tClient:" +
                "\n\t\tdni= " + dni +
                "\n\t\tfirstName= " + firstName +
                "\n\t\tlastName= " + lastName +
                "\n\t\tphone Number= " + phoneNumber +
                "\n\t\tlocalizerIds= " + localizerIds.toString();
    }
}
