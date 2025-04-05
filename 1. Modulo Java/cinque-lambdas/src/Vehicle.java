public class Vehicle {
    private String model;
    private String brand;
    private Double price;

    public Vehicle(String model, String brand, Double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nVehicle:" +
                "\nmodel= " + model +
                "\nbrand= " + brand +
                "\nprice= " + price;
    }
}
