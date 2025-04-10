package ejerciciotres;

public class Gato extends Animal implements Carnivoro{
    public String nombre;
    public int edad;

    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau!!!");
    }

    @Override
    public String comer() {
        return "Soy un gatito que come carne";
    }
}
