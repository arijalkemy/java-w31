package INT_CarreraDeLaSelva;

public class Participante {
    int numeroParticipante;
    String dni;
    String nombre;
    String apellido;
    int edad;

    // Constructor
    public Participante(int numeroParticipante, String dni, String nombre, String apellido, int edad) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
