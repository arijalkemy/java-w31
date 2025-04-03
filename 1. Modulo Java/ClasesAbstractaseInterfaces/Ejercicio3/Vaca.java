package ClasesAbstractaseInterfaces.P1.Ejercicio3;

public class Vaca extends Animal implements Herviboro {
    public Vaca(String nombre, int edad, String especie) {
        super(nombre, edad, especie);
    }

    @Override
    public void emitirSonido() {
        if (this.animalComido()) {
            System.out.println("La vaca " + getNombre() + " no puede emitir sonidos, fue comida.");
            return;
        }
        System.out.println("Muu");
    }
    @Override
    public void comerHierba() {
        if (this.animalComido()) {
            System.out.println("La vaca " + getNombre() + " no puede comer hierba, fue comida.");
            return;
        }
        System.out.println("La vaca " + getNombre() + " está comiendo hierba.");
    }
}
