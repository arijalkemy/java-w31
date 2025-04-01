package animalesAbstractos;

public class Gato extends Animal implements Carnivoro {
    public void hacerRuido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gato y estoy comiendo carne");
    }
}
