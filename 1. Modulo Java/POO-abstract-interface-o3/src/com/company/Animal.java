package com.company;

public abstract class Animal{
    private String nombre;
    private Integer edad;

    public Animal(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public abstract void emitirSonido();

    public static void comerAnimal(Animal a){
        if (a instanceof ComerCarne){
            System.out.println("Estoy comiendo Carne");
        }else if (a instanceof ComerHierba){
            System.out.println("Estoy comiendo Hierbas");
        }
    }
}
