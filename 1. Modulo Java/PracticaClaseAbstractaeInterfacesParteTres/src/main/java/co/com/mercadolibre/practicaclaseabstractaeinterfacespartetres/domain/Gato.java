package co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain;

import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.services.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void comerCarne() {
        System.out.println("Gato come carne.");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Gato: Miau!");
    }

}
