package model;

public class Participante {

    private int numero;
    private String dni;
    private String nombre;
    private int edad;
    private String apellido;
    private String telefono;
    private String numeroEmergencia;
    private String grupoSanguineo;
    private boolean inscrito;

    public Participante(int numero,String dni, String nombre, String apellido, int edad, String telefono, String numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = apellido;
        this.telefono = telefono;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.inscrito = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public boolean isInscrito() {
        return inscrito;
    }

    public void setInscrito(boolean inscrito) {
        this.inscrito = inscrito;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numero=" + numero +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", numeroEmergencia='" + numeroEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
