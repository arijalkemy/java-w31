package ejerciciotres;

public class Perro extends Animal implements Carnivoro {

    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau!!");
    }

    @Override
    public String comer() {
        return "Soy un perro y estoy comiendo carne";
    }
}
