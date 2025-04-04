package Model.Ejercicio3.Animales;

import Model.Ejercicio3.Alimentacion.AlimentacionHervibora;

public class Vaca extends Animal implements AlimentacionHervibora {
    @Override
    public String emitirSonido() {
        return "muu";
    }

    @Override
    public void comer() {
        this.comerHierva();
    }

    @Override
    public void comerHierva() {
        System.out.println("Soy una Vaca que implementa el metodo comerHierva");
    }
}
