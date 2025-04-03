package exerciseInterface.punto3.clases;

import exerciseInterface.punto3.interfaz.AlimentacionCarnivoros;

public class Perro extends Animal implements AlimentacionCarnivoros {

    @Override
    public void emitirsonido() {
       System.out.println(" guau ");
    }

    @Override
    public void tipoAlimentacion() {
       System.out.println(" El perro es carnivoro");
    }

    @Override
    public void comer() {
       this.tipoAlimentacion();
    }

}
