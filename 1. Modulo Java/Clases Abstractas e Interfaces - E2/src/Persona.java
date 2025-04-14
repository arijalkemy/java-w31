import java.util.List;

public class Persona implements Imprimir {
    String nombre;
    String apellido;
    String ciudad;
    List<String> habilidades;

    public Persona(String nombre, String apellido, String ciudad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.habilidades = habilidades;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nCiudad: " + ciudad +
                "\nHabilidades" + habilidades;
    }

    @Override
    public void imprimirContenido() {
        System.out.println("Curriculum");
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Habilidades: " + habilidades);
    }
}
