package clase.POO.integrador2.ejercicio1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        int codigo = guardaRopa.guardarPrendas((List.of(new Prenda("nike", "chomba")   ,  new Prenda("adidas", "camisa")   )));
        int codigo2 = guardaRopa.guardarPrendas((List.of(new Prenda("adidas", "no se")   ,  new Prenda("reebok", "classic")   )));
        System.out.println(guardaRopa.devolverPrendas(codigo).toString());
        guardaRopa.mostrarPrendas();
    }
}
