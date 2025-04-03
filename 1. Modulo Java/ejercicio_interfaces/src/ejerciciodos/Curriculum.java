package ejerciciodos;

public class Curriculum implements IImprimible {
    private String nombre;
    private String apellido;
    private int edad;
    private String[] habilidades;

    public Curriculum(String nombre, String apellido, int edad, String[] habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum:");
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Habilidades: " + String.join(", ", habilidades));
    }
}