package EjerciciosIntegradores.SupermercadoElEconomico;

public class Cliente {
    Long dni;
    String nombre;
    String apellido;

    public Cliente(Long dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
}
