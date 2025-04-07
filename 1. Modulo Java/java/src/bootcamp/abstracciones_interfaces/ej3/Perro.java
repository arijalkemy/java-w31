package bootcamp.abstracciones_interfaces.ej3;

public class Perro extends Animal implements Carnivoro {
    @Override
    void emitirSonido() {
        System.out.println("Guau");
    }
    void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne.");
    }
}
