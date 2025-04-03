package carreradelaselva;

public class Participante {

    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String contactoEmergencia;
    private String grupoSanguineo;

    public Participante(int id, String dni, String nombre, String apellido, int edad, String telefono, String contactoEmergencia, String grupoSanguineo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.contactoEmergencia = contactoEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }
}
