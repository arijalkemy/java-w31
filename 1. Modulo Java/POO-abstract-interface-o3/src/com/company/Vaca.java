package com.company;

public class Vaca extends Animal implements ComerHierba{

    private Integer cantHijos;

    public Vaca(String nombre, Integer edad, Integer cantHijos) {
        super(nombre, edad);
        this.cantHijos = cantHijos;
    }

    public Integer getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(Integer cantHijos) {
        this.cantHijos = cantHijos;
    }

    @Override
    public String toString() {
        return "Vaca{" +
                "cantHijos=" + cantHijos +
                '}';
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comer() {
        System.out.println("Estoy comiendo Hierbas");
    }
}
