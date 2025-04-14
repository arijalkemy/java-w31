package clasesAbstractasEInterfaces.ejercicio2;

public class Curriculum implements IImprimible {
    private String nombre;
    private String apellido;
    private int edad;
    private String profesion;

    public Curriculum(String nombre, String apellido, int edad,  String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.profesion = profesion;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre + " - Apellido: " + apellido + " - Edad: " + edad + " - Profesion: " + profesion);
    }
}
