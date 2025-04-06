public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("MUUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca que esta comiendo hierba");
    }
}