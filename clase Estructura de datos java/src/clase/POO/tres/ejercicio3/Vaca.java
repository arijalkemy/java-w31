package clase.POO.tres.ejercicio3;

public class Vaca extends Animal implements Herbivoro{
    @Override
    public void emitirSonido() {
        System.out.println( "Muuuuu");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
