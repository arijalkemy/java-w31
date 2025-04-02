package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.interfaces.Carnivoro;
import com.mercadolibre.bootcamp.interfaces.Herviboro;
import com.mercadolibre.bootcamp.model.Animal;
import com.mercadolibre.bootcamp.model.Gato;
import com.mercadolibre.bootcamp.model.Perro;
import com.mercadolibre.bootcamp.model.Vaca;

public class Main {


    public static void comerAnimal(Animal animal) {
        if(animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        }else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        }
    }

    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.generarSonido();
        gato.generarSonido();
        vaca.generarSonido();

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();
        System.out.println();
        System.out.println("Usando método Comer Animal: ");
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }
}
