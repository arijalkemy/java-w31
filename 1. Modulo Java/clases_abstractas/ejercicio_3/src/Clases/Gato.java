package Clases;

import Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }
    @Override
    public String comerCarne() {
        return "mmm carne";
    }
}
