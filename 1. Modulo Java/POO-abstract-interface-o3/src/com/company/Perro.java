package com.company;

public class Perro extends Animal implements ComerCarne{
    private Integer cantPeleas;

    public Perro(String nombre, Integer edad, Integer cantPeleas) {
        super(nombre, edad);
        this.cantPeleas = cantPeleas;
    }

    public Integer getCantPeleas() {
        return cantPeleas;
    }

    public void setCantPeleas(Integer cantPeleas) {
        this.cantPeleas = cantPeleas;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "cantPeleas=" + cantPeleas +
                '}';
    }

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comer() {
        System.out.println("Estoy comiendo Carne");
    }
}
