public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau, guau, guau");
    }


    @Override
    public void comerCarne() {
        System.out.println("Guau, guau! Comiendo carne!");
    }
}
