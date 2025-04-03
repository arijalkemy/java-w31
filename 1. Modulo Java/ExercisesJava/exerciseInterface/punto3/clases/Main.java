package exerciseInterface.punto3.clases;

import exerciseInterface.punto3.interfaz.Comer;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Vaca vaca =new Vaca();
        Perro perro = new Perro();

        gato.emitirsonido();
        vaca.emitirsonido();
        perro.emitirsonido();

        Comer.comerAnimal(perro);
        Comer.comerAnimal(gato);
        Comer.comerAnimal(vaca);
     
    
    }
}
