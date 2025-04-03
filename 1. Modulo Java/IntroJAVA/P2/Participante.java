package IntroJAVA.P2;

public class Participante {
    private static int contadorParticipantes = 0;

    private int id;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int númeroEmergencia;
    private String grupoSanguíneo;

    public Participante(int dni, String nombre, String apellido, int edad, int celular, int númeroEmergencia, String grupoSanguíneo) {
        this.id = contadorParticipantes++;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.númeroEmergencia = númeroEmergencia;
        this.grupoSanguíneo = grupoSanguíneo;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getId() {
        return this.id;
    }

    public int getDni() {
        return this.dni;
    }

    public int getCelular() {
        return this.celular;
    }

    public int getNúmeroEmergencia() {
        return this.númeroEmergencia;
    }
    
    public String getGrupoSanguíneo() {
        return this.grupoSanguíneo;
    }
}