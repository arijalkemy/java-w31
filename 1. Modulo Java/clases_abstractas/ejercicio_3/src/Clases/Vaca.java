package Clases;

import Interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void hacerSonido(){
        System.out.println("muuu");
    }
    @Override
    public String comerHierba(){
        return "mmm pastito";
    }
}
