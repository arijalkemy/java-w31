package clasesAbstractasEInterfaces.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.hacerSonido();
        gato.hacerSonido();
        vaca.hacerSonido();

        ((ICarnivoro) perro).comerCarne();
        ((ICarnivoro) gato).comerCarne();
        ((IHerviboro) vaca).comerHierba();
    }
}
