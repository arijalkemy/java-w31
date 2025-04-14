package clasesAbstractasEInterfaces.ejercicio3;

public class Perro extends Animal implements ICarnivoro{
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }
}
