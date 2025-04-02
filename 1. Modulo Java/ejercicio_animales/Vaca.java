package E3;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierbas() {
        System.out.println("La vaca come hierbas");
    }

}
