package documentos;

public class Curriculum implements Documento {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String direccion;
    private String fechaNacimiento;

    public Curriculum(String nombre, String apellidos, String telefono, String email, String direccion, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public void imprimirEnConsola() {
        System.out.println("Currículum:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
    }
}
