package ejercicio_carrera;

public class Participante {
    public int numero;
    public int dni;
    public String nombre;
    public String apellido;
    public int edad;
    public String celular;
    public String numeroEmergencia;
    public String grupoSanguineo;

    public Participante(int numero, int dni, String nombre, String apellido, int edad, String celular,
            String numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

}
