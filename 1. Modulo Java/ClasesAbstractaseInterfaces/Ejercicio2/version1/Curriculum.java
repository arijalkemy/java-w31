package ClasesAbstractaseInterfaces.P1.Ejercicio2.version1;

// - Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private String[] habilidades;

    public Curriculum(String nombre, String apellido, String[] habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Curriculum...");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.print("Habilidades: ");
        for (String habilidad : habilidades) {
            System.out.print(habilidad + " ");
        }
        System.out.println();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }
    public String[] getHabilidades() {
        return habilidades;
    }

}
