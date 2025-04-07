package bootcamp.abstracciones_interfaces.ej3;

public abstract class Animal {
    abstract void emitirSonido();
    abstract void comer();
    static void comerAnimal(Animal animal){
        animal.comer();
    };
 //   static void comerAnimal(Animal animal) {
 //       if (animal instanceof Carnivoro) {
 //           ((Carnivoro) animal).comerCarne();
 //       } else if (animal instanceof Herbivoro) {
 //           ((Herbivoro) animal).comerHierba();
 //       }
 //   }
}
