package ejerciciotres.modelos;

import ejerciciotres.interfaces.Animal;
import ejerciciotres.interfaces.IHerviboros;

public class Vaca extends Animal implements IHerviboros {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca herviboro");
    }
}
