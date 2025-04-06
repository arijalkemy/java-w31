package co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres;

import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain.AlimentadorDeAnimales;
import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain.Animal;
import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain.Gato;
import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain.Perro;
import co.com.mercadolibre.practicaclaseabstractaeinterfacespartetres.domain.Vaca;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        System.out.println("\nAlimentación:");
        AlimentadorDeAnimales.comerAnimal(perro);
        AlimentadorDeAnimales.comerAnimal(gato);
        AlimentadorDeAnimales.comerAnimal(vaca);    }
}