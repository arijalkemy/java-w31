package sistemasuper;

public class Cliente {
    private Integer dni;
    private String nombre;
    private String apellido;


    public Cliente(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String toString(){
        return "Dni: " + dni + " \nNombre: " + nombre + " \nApellido: " + apellido;
    }

    public Integer getDni() {
        return dni;
    }
}
