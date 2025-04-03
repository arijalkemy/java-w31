package ejerciciotres;

import com.ejerciciotres.modelos.*;
import ejerciciotres.interfaces.Animal;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.emitirSonido();
        comerAnimal(perro);

        gato.emitirSonido();
        comerAnimal(gato);

        vaca.emitirSonido();
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        animal.comer();
    }
}
