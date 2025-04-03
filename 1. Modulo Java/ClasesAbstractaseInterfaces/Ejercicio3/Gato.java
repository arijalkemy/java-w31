package ClasesAbstractaseInterfaces.P1.Ejercicio3;

public class Gato extends Animal implements Carnivoro {
    public Gato(String nombre, int edad, String especie) {
        super(nombre, edad, especie);
    }
    @Override
    public void emitirSonido() {
        if (this.animalComido()) {
            System.out.println("El gato " + getNombre() + " no puede emitir sonidos, fue comido.");
            return;
        }
        System.out.println("Miau");
    }
    @Override
    public void comerCarne() {
        if (this.animalComido()) {
            System.out.println("El gato " + getNombre() + " no puede comer carne, fue comido.");
            return;
        }
        System.out.println("El gato " + getNombre() + " está comiendo carne.");
    }
    @Override
    public void comerAnimal(Animal animal) {
        if (this.animalComido() || animal.animalComido()) {
            System.out.println("El gato " + getNombre() + " no puede comer al animal " + animal.getEspecie() + ", fue comido.");
            return;
        }
        System.out.println("El gato " + getNombre() + " está comiendose al animal " + animal.getEspecie());
        animal.comer();
        System.out.println("El animal " + animal.getEspecie() + " ha sido comido.");
    }
}
