public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Meow, meow, meow");
    }


    @Override
    public void comerCarne() {
        System.out.println("Meow, meow! Comiendo atún!");
    }
}
