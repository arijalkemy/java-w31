package com.bootcamp.inheritance;

public class NonPerishable extends Product{
    private String type;

    public NonPerishable(String name, Double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return super.toString() + ", Type: " + type;
    }
}
