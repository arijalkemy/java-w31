package com.bootcamp.inheritance;

public class Perishable extends Product {
    private Integer daysLeftToExpire;

    public Perishable(String name, Double price, Integer daysLeftToExpire) {
        super(name, price);
        this.daysLeftToExpire = daysLeftToExpire;
    }

    public Integer getDaysLeftToExpire() {
        return daysLeftToExpire;
    }

    public void setDaysLeftToExpire(Integer daysLeftToExpire) {
        this.daysLeftToExpire = daysLeftToExpire;
    }

    public String toString() {
        return super.toString() + ", Days left to expire: " + daysLeftToExpire;
    }

    @Override
    public Double calculate(Integer productAmount) {
        Double price = super.calculate(productAmount);

        switch (daysLeftToExpire) {
            case 1:
                price -= price * 0.4;
                break;
            case 2:
                price -= price  * 0.3;
                break;
            case 3:
                price -= price * 0.5;
        }
        return price;
    }
}
