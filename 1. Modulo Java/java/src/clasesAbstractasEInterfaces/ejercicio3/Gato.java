package clasesAbstractasEInterfaces.ejercicio3;

public class Gato extends Animal implements ICarnivoro{
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }
}
