package ABSeINT_Animal;
public abstract class Animal {
    public abstract void emitirSonido();

    public void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herbivoro) {
            ((Herbivoro) animal).comerHierba();
        } else {
            System.out.println("Este animal no tiene un comportamiento alimenticio definido");
        }
    }
}

