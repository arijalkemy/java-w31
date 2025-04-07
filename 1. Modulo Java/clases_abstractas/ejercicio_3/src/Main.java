import Clases.Vaca;
import Clases.Animal;
import Clases.Gato;
import Clases.Perro;
public class Main {
    public static void main(String[] args) {
        // Vaca vaca = new Vaca();
        // System.out.println(vaca.comerHierba());
        Perro perro = new Perro();
        System.out.println(perro.comerCarne());
        Gato gato = new Gato();
        System.out.println(gato.comerCarne());
    }
}
