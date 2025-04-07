import java.util.List;

class Curriculum implements Imprimible {
    private String nombre;
    private int edad;
    private List<String> habilidades;

    public Curriculum(String nombre, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum de " + nombre + ", Edad: " + edad + ", Habilidades: " + habilidades;
    }
}
