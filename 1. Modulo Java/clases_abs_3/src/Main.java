public class Main {
    public static void main(String[] args) {
        Perro perro1 = new Perro("Simur");
        Gato gato1 = new Gato("Tomate");
        Vaca vaca1 = new Vaca("Lola");

        perro1.emitirSonido();
        perro1.comerCarne();

        gato1.emitirSonido();
        gato1.comerCarne();

        vaca1.emitirSonido();
        vaca1.comerHierba();

    }
}