package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SaveTheRopa {

    public static void main(String[] args) {
	    Prenda p1 = new Prenda("HyM","Campera");
	    Prenda p2 = new Prenda("Levis","Top");
	    List<Prenda> listaPrenda = new ArrayList<>();
	    listaPrenda.add(p1);
	    listaPrenda.add(p2);

	    GuardaRopa guardaRopa = new GuardaRopa();
	    System.out.println(guardaRopa.guardarPrendas(listaPrenda));

	    guardaRopa.mostrarPrendas();

    }
}
