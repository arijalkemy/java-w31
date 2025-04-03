package Practica2;

public class Inscripcion {
	
	private int nroIncripcion;
	private Categoria categoria;
	private Participante participante;
	private double valor;
	
	public Inscripcion(int nroIncripcion, Categoria categoria, Participante participante) {
		super();
		this.nroIncripcion = nroIncripcion;
		this.categoria = categoria;
		this.participante = participante;
		this.calcularValor();
	}
	
	private void calcularValor() {
		int edad = this.participante.getEdad();
		if(edad>18) {
			if(this.getCategoria().isMayores()) {
				this.setValor(this.getCategoria().isValorMayores());
			}		
		}
		else {
			if(this.getCategoria().isMenores()) {
				this.setValor(this.getCategoria().isValorMenores());
			}
			if(!this.getCategoria().isMenores() && edad < 18) {
				//no puede participar
			}
		}
	}
	
	
	public int getNroIncripcion() {
		return nroIncripcion;
	}
	
	public void setNroIncripcion(int nroIncripcion) {
		this.nroIncripcion = nroIncripcion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Participante getParticipante() {
		return participante;
	}
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
	
	

}
