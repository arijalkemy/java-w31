public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("GUAU");
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro que esta comiendo carne");
    }
}
