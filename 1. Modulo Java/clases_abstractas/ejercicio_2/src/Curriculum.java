import java.util.ArrayList;

public class Curriculum extends Documento {
    private ArrayList<String> habilidades;
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    public Curriculum(String nombre, String apellido, int edad, String dni){
        this.habilidades = new ArrayList<>();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }
    
    public void agregarHabilidad(String habilidad) {
        habilidades.add(habilidad);
    }

    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("NOMBRE: " + nombre.toUpperCase());
        System.out.println("APELLIDO: " + apellido.toUpperCase());
        System.out.println("EDAD: " + edad + " AÑOS");
        System.out.println("DNI: " + dni);
        System.out.println("HABILIDADES: \n");
        for (String habilidad: habilidades){
            System.out.println("- " + habilidad.toUpperCase());
        }
    }
}
