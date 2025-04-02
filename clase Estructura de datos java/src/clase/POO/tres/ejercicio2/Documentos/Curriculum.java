package clase.POO.tres.ejercicio2.Documentos;

import java.util.List;

public class Curriculum implements Documento {
    private String nombre;
    private String apellido;
    private String telefono;
    private List<String> listaHabilidades;

    public Curriculum(String nombre, String apellido, String telefono, List<String> listaHabilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.listaHabilidades = listaHabilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("\nImprimiendo curriculum");
        System.out.println("Nombre: " + nombre + "\nApellido: " + apellido + "\nTelefono: " + telefono);
        System.out.println(listaHabilidades);
    }
}
