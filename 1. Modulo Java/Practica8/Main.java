package Practica8;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GuardaRopa guarda = new GuardaRopa();
        Integer codigo = guarda.guardarPrendas(List.of(new Prenda("nike", "chomba")   ,  new Prenda("adidas", "camisa")   ));
        Integer codigodos = guarda.guardarPrendas(List.of(new Prenda("nike", "90")   ,  new Prenda("adidas", "zapatillas")   ));

        guarda.mostrarPrendas();
        List<Prenda> prendas = guarda.devolverPrendas(codigo);
        List<Prenda> prendasdos = guarda.devolverPrendas(codigodos);

        System.out.println(prendas);
        System.out.println(prendasdos);



    }
}
