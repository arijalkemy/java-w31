package com.company;

public class Main {

    public static void main(String[] args) {
        Gato gato = new Gato("Juan",2,"Verdes");
        gato.emitirSonido();
        gato.comer();

        Perro p = new Perro("Pedro",3,6);
        p.emitirSonido();
        p.comer();

        Animal vaca = new Vaca("Vaquita",3,1);
        vaca.emitirSonido();
        if( vaca instanceof ComerHierba){
            ((ComerHierba) vaca).comer();
        }

        System.out.println("\nNuevo requeriiento:\n");
        Animal.comerAnimal(gato);
        Animal.comerAnimal(p);
        Animal.comerAnimal(vaca);

    }
}
