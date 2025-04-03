package exerciseInterface.punto3.clases;

import exerciseInterface.punto3.interfaz.AlimentacionCarnivoros;

public class Gato extends Animal implements AlimentacionCarnivoros{

    @Override
    public void emitirsonido() {
       System.out.println(" Miau ");
    }

    @Override
    public void tipoAlimentacion() {
        System.out.println(" El gato es carnivoro");
    }

    @Override
    public void comer() {
      this.tipoAlimentacion();
    }

}
