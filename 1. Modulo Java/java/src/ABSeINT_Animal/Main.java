package ABSeINT_Animal;
public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        // Emitir sonidos
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        comerVariosAnimales(perro);
        comerVariosAnimales(gato);
        comerVariosAnimales(vaca);
    }

    public static void comerVariosAnimales(Animal animal) {
        System.out.println("Comiendo el animal:");
        animal.comerAnimal(animal);
        System.out.println();
    }
}