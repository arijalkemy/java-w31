package savetheropa;

import java.util.Objects;

public class Prenda {

    private String marca;
    private int modelo;
    private String color;

    public Prenda(String marca, int modelo, String color) {
        this.marca = Objects.requireNonNull(marca, "La marca no puede ser nula");
        this.modelo = modelo;
        this.color = Objects.requireNonNull(color, "El color no puede ser nulo");
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    // Setters con validaciones
    public void setMarca(String marca) {
        this.marca = Objects.requireNonNull(marca, "La marca no puede ser nula");
    }

    public void setModelo(int modelo) {
        if (modelo <= 0) {
            throw new IllegalArgumentException("El modelo debe ser un número positivo");
        }
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = Objects.requireNonNull(color, "El color no puede ser nulo");
    }

    @Override
    public String toString() {
        return String.format("Prenda {Marca: %s, Modelo: %d, Color: %s}", marca, modelo, color);
    }
}
