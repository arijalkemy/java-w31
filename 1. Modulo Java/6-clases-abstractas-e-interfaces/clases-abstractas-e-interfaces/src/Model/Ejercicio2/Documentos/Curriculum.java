package Model.Ejercicio2.Documentos;

import Model.Ejercicio2.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<String> habilidades = new ArrayList<>();

    @Override
    public void imprimir() {
        System.out.println("Soy un Curriculum que implementa el metodo imprimir");
    }
}
