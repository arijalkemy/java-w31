package ejerciciotres;



public interface Carnivoro {

    static void comerAnimal (Carnivoro animal) {
        System.out.println(animal.comer());
    }

    String comer();
}
