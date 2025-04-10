package ejerciciotres;

public interface Hervivoro {

    static void comerAnimal (Hervivoro animal) {
        System.out.println(animal.comer());
    }
    String comer();
}
