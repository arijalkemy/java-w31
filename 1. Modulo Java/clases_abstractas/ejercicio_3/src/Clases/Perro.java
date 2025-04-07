package Clases;

import Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void hacerSonido() {
        System.out.println("guau");
    }
    @Override
    public String comerCarne(){
        return "mmm carne";
    }
}
