package ejerciciotres;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro("Pablito", 3);
        Vaca vaca = new Vaca("Lola", 10);
        Gato gato = new Gato("Mali", 2);

        Carnivoro.comerAnimal(perro);
        Carnivoro.comerAnimal(gato);
        Hervivoro.comerAnimal(vaca);


    }
}
