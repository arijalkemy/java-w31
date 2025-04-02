package clase.estructura.datos.dos;

public class Participant {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numero_emergencia;
    private String grupo_sanguineo;
    private int precio;
    private String categoria;

    public Participant(int id, String nombre, String apellido, int edad, String celular, String numero_emergencia, String grupo_sanguineo, int precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numero_emergencia = numero_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String toString(){
        return "ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad + "\nCelular: " + celular + "\nNumero de Emergencia: " + numero_emergencia + "\nGrupo Sanguineo: " + grupo_sanguineo + "\nCategoria de circuito: " + categoria + "\nPrecio inscripción: " + precio;
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getPrecio() {
        return precio;
    }
}
