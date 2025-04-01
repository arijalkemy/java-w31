package org.example.animalesAbstractos;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.hacerRuido();
        gato.hacerRuido();
        vaca.hacerRuido();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herbivoro) {
            ((Herbivoro) animal).comerHierba();
        } else {
            throw new IllegalArgumentException("Este animal no tiene sus gustos definidos");
        }
    }

}
