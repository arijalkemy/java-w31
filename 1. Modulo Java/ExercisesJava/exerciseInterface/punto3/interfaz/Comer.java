package exerciseInterface.punto3.interfaz;

import exerciseInterface.punto3.clases.Animal;

public interface Comer {
    static void  comerAnimal(Animal animal){
        animal.comer();
    }
}
