public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        System.out.println("Animales cantando :)");
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        System.out.println("\nHora de comer!");
        Alimentacion.comerAnimal(perro);
        Alimentacion.comerAnimal(gato);
        Alimentacion.comerAnimal(vaca);
    }
}