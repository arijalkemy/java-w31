public class Persona {
    String nombre;
    String apellido;
    int edad;
    int dni;
    String celular;
    String numeroEmergencia;
    String grupoSanguineo;

    public Persona(String nombre, String apellido, int edad, int dni, String celular, String numeroEmergencia, String grupoSanguineo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public boolean esMayor(){
        return this.edad > 18;
    }


}
