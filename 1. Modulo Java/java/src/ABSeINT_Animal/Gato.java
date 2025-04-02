package ABSeINT_Animal;
public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("El gato dice: miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne.");
    }
}