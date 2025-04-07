package bootcamp.abstracciones_interfaces.ej3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido(); // Salida: Guau
        gato.emitirSonido();  // Salida: Miau
        vaca.emitirSonido();  // Salida: Muu

        vaca.comer();
        perro.comer();
        gato.comer();

        Animal.comerAnimal(perro);
    }
}
