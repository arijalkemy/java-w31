package com.mercadolibre;

public class Main {
    public static void main (String[]args){
        Vaca vaca = new Vaca("Lola");
        Perro perro = new Perro("Lolo");
        Gato gato = new Gato("Iris");

        vaca.comerHierba();
        vaca.emitirSonido();
        System.out.println("----------------------------");
        perro.comerCarne();
        perro.emitirSonido();
        System.out.println("----------------------------");
        gato.comerCarne();
        gato.emitirSonido();

        System.out.println("----------------------------");
        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);

    }

    /*Como propuesta extra se sugiere llamar a un método comerAnimal donde a partir del pasaje de un objeto de
        cualquier tipo de animal como parámetro, invoque al método para comer según corresponda a dicho animal.*/
    public static void comerAnimal(Animal animal){
        if(animal instanceof ComibleCarnivoro){
            ((ComibleCarnivoro) animal).comerCarne();
        } else if (animal instanceof ComibleHerbivoro){
            ((ComibleHerbivoro) animal).comerHierba();
        } else {
            System.out.println("El animal no tiene una dieta definida");
        }
    }

}
