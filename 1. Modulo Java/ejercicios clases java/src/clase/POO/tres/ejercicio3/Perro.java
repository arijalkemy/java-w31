package clase.POO.tres.ejercicio3;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Guauuu");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
