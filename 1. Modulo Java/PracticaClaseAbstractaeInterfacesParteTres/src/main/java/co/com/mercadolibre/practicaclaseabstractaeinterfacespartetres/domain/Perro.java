package co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain;

import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.services.Carnivoro;

public class Perro extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Perro: ¡Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro come carne.");
    }

}
