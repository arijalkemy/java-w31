package com.mercadolibre.modulojava.interfacestres;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Perro perro = new Perro();
        perro.hacersonido();
        Gato gato = new Gato();
        gato.hacersonido();
        Vaca vaca = new Vaca();
        vaca.hacersonido();
        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();


        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);


    }
     public static void comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
             ((Vaca) animal).comerHierba();
        }

    }
}



