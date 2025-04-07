package ejercicio3;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}
