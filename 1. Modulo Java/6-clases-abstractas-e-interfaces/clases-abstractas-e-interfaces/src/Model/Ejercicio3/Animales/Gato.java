package Model.Ejercicio3.Animales;

import Model.Ejercicio3.Alimentacion.AlimentacionCarnivora;

public class Gato extends Animal implements AlimentacionCarnivora {
    @Override
    public String emitirSonido() {
        return "miau";
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un Gato que implementa el metodo comerCarne");
    }
}
