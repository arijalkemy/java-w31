package E3;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierbas();

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierbas();
        }
    }
}
