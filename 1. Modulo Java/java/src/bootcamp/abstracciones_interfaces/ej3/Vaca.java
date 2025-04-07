package bootcamp.abstracciones_interfaces.ej3;

public class Vaca extends Animal implements Herbivoro{
    @Override
    void emitirSonido() {
        System.out.println("Muu");
    }
    void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba.");
    }
}
