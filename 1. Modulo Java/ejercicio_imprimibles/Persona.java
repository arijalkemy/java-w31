package E2;

public class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String profesion;

    public Persona(String nombre, String apellido, String telefono, String email, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email
                + ", profesion=" + profesion + "]";
    }
}
