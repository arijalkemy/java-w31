public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Mouuuuuuuuuuuuuuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Muuuuuuuuuu! Comiendo pastito!");
    }
}
