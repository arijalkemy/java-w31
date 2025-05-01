import java.util.List;

public class Curriculum implements Imprimir {
    private String nombre;
    private String apellido;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum de " + nombre + " " + apellido);
        System.out.println("Habilidades: " + String.join(", ", habilidades));
    }
}
