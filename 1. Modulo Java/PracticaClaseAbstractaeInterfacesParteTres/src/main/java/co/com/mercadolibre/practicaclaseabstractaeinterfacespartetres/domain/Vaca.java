package co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain;

import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.services.Herviboro;

public class Vaca extends Animal implements Herviboro{
    
    @Override
    public void emitirSonido() {
        System.out.println("Vaca: ¡Muuu!");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca come hierba.");
    }
}
