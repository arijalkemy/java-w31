package Model.Ejercicio3.Animales;

import Model.Ejercicio3.Alimentacion.AlimentacionCarnivora;

public class Perro extends Animal implements AlimentacionCarnivora {
    @Override
    public void comerCarne() {
        System.out.println("Soy un Perro que implementa el metodo comerCarne");
    }

    @Override
    public String emitirSonido() {
        return "guau";
    }

    @Override
    public void comer() {
        this.comerCarne();
    }
}
