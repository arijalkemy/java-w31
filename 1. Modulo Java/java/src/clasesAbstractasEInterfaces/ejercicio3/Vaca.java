package clasesAbstractasEInterfaces.ejercicio3;

public class Vaca extends Animal implements IHerviboro {
    @Override
    public void hacerSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}
