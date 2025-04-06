package co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain;

import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.services.Carnivoro;
import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.services.Herviboro;

public class AlimentadorDeAnimales {
    public static void comerAnimal(Animal animal) {
        
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        } else {
            System.out.println("Este animal no tiene definido un tipo de alimentación.");
        }
    }
}
