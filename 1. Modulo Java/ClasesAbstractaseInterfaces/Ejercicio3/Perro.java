package ClasesAbstractaseInterfaces.Ejercicio3;

public class Perro extends Animal implements Carnivoro {
    public Perro(String nombre, int edad, String especie) {
        super(nombre, edad, especie);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }
    @Override
    public void comerCarne() {
        if (this.animalComido()) {
            System.out.println("El perro " + getNombre() + " no puede comer carne, fue comido.");
            return;
        }
        System.out.println("El perro " + getNombre() + " está comiendo carne.");
    }
    @Override
    public void comerAnimal(Animal animal) {
        if (this.animalComido() || animal.animalComido()) {
            System.out.println("El perro " + getNombre() + " no puede comer al animal " + animal.getEspecie() + ", fue comido.");
            return;
        }
        System.out.println("El perro " + getNombre() + " está comiendose al animal " + animal.getEspecie());
        animal.comer();
        System.out.println("El animal " + animal.getEspecie() + " ha sido comido.");
    }
}
