package exerciseIntegrator2.exercise1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> listaDePrenda = List.of(new Prenda("Kenzo", "Coleccion"),
        new Prenda("Koaj", "Primaveral")) ;

        GuardarRopa guardarRopa = new GuardarRopa();
       Integer key = guardarRopa.guardarPrendas(listaDePrenda);

        guardarRopa.mostrarPrendas();

        System.out.println(guardarRopa);
    
    }
}
