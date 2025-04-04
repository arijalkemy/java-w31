package org.example.models;

public abstract class Animal {

    public void emitirSonido(){
        System.out.println("El animal está emitiendo un sonido.");
    }

    public void comer(){
        System.out.println("El animal está comiendo.");
    }

    public void comerAnimal (Object animal){
        if(animal instanceof Gato || animal instanceof Perro){
            System.out.println("soy carnivoro");
        }else if(animal instanceof Vaca){
            System.out.println("soy herbivoro");
        }else{
            System.out.println("no sé que soy");
        }

    }
}
