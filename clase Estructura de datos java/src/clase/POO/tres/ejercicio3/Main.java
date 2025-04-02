package clase.POO.tres.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        perro.emitirSonido();
        perro.comer();

        Animal gato = new Gato();
        gato.emitirSonido();
        gato.comer();

        Animal vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comer();

        comerAnimal(perro);
    }



    public static void comerAnimal(Animal animal) {
        animal.comer();
    }
}
