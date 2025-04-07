package polimorfismo;
public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro("Perro", "tito");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Gato gato = new Gato("Gato", "Pucho");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();
    }
}
