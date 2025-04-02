package ABSeINT_Animal;
public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("La vaca dice: muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo pasto");
    }
}
