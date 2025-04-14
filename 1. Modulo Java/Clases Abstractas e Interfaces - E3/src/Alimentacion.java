public class Alimentacion {
    public static void comerAnimal(Animal animal) {
        if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else {
            ((Vaca) animal).comerHierba();
        }
    }
}
