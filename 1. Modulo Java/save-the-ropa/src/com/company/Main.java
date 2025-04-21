package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
      List<Prenda> prendas = new ArrayList<>();

      Prenda prenda1 = new Prenda("zara", "camisa");
      Prenda prenda2 = new Prenda("levis", "jeans");

      prendas.add(prenda1);
      prendas.add(prenda2);

	  GuardaRopa guarda1 = new GuardaRopa(1 );

	  Integer clave1 = guarda1.guardarPrendas(prendas);
        System.out.println(clave1);

	  List<Prenda> prendasClave1 = guarda1.devolverPrendas(clave1);
	  prendasClave1.stream().forEach(System.out::println);

	  guarda1.mostrarPrendas();
    }
}
