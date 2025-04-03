import clases.Guardaropa;
import clases.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Guardaropa guardaropa = new Guardaropa();
        List<Prenda> listaDePrendas = new ArrayList<>();
        Prenda prendauno = new Prenda("Nike", "Air");
        Prenda prendados = new Prenda("Gucci", "Base");
        listaDePrendas.add(prendados);
        listaDePrendas.add(prendauno);


        List<Prenda> listaDePrendasDos = new ArrayList<>();
        Prenda prendaunolistados = new Prenda("aDIDAS", "POBBRE");
        Prenda prendadoslistados = new Prenda("Patito", "patitos");

        listaDePrendasDos.add(prendaunolistados);
        listaDePrendasDos.add(prendadoslistados);

        guardaropa.guardarPrendas(listaDePrendas);
        guardaropa.guardarPrendas(listaDePrendasDos);
        guardaropa.mostrarPrenas();


        System.out.println(guardaropa.devolverPrendas(3));

    }
}
