package Practica2;

public class Participante {
	
	private int numeroDeParticipante;
	private String nombre;
	private int edad;
	private String dni;
	private String apellido;
	private String celular;
	private String numeroDeEmergencia;
	private String grupoSanguineo;
	
	public Participante(int numeroDeParticipante, String nombre, int edad, String dni, String apellido, String celular,
			String numeroDeEmergencia, String grupoSanguineo) {
		super();
		this.numeroDeParticipante = numeroDeParticipante;
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.apellido = apellido;
		this.celular = celular;
		this.numeroDeEmergencia = numeroDeEmergencia;
		this.grupoSanguineo = grupoSanguineo;
	}


	public int getNumeroDeParticipante() {
		return numeroDeParticipante;
	}


	public void setNumeroDeParticipante(int numeroDeParticipante) {
		this.numeroDeParticipante = numeroDeParticipante;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getNumeroDeEmergencia() {
		return numeroDeEmergencia;
	}


	public void setNumeroDeEmergencia(String numeroDeEmergencia) {
		this.numeroDeEmergencia = numeroDeEmergencia;
	}


	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}


	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

}
