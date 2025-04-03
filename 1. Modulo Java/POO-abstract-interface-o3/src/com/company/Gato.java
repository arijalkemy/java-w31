package com.company;

public class Gato extends Animal implements ComerCarne{

    private String colorOjos;

    public Gato(String nombre, Integer edad, String colorOjos) {
        super(nombre, edad);
        this.colorOjos = colorOjos;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "colorOjos='" + colorOjos + '\'' +
                '}';
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comer() {
        System.out.println("Estoy comiendo Carne");
    }
}
