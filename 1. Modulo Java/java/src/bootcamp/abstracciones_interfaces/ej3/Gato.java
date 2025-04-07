package bootcamp.abstracciones_interfaces.ej3;

public class Gato extends Animal implements Carnivoro {
    @Override
    void emitirSonido() {
        System.out.println("Miau");
    }
    void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne.");
    }
}
