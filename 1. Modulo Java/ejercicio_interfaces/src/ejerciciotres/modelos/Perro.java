package ejerciciotres.modelos;

import ejerciciotres.interfaces.Animal;
import ejerciciotres.interfaces.ICarnivoros;

public class Perro extends Animal implements ICarnivoros {
    @Override
    public void emitirSonido() {
        System.out.println("Guau guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro carnivoro");
    }
}
