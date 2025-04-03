package Practica2;

public class Categoria {

	private int id;
	private String nombre;
	private String descrpicion;
	private boolean menores;
	private boolean mayores;
	private int valorMenores;
	private int valorMayores;
	
	public Categoria(int id, String nombre, String descrpicion, boolean menores, boolean mayores, int valorMenores,
			int valorMayores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descrpicion = descrpicion;
		this.menores = menores;
		this.mayores = mayores;
		this.valorMenores = valorMenores;
		this.valorMayores = valorMayores;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescrpicion() {
		return descrpicion;
	}
	public void setDescrpicion(String descrpicion) {
		this.descrpicion = descrpicion;
	}
	public boolean isMenores() {
		return menores;
	}
	public void setMenores(boolean menores) {
		this.menores = menores;
	}
	public boolean isMayores() {
		return mayores;
	}
	public void setMayores(boolean mayores) {
		this.mayores = mayores;
	}
	public int isValorMenores() {
		return valorMenores;
	}
	public void setValorMenores(int valorMenores) {
		this.valorMenores = valorMenores;
	}
	public int isValorMayores() {
		return valorMayores;
	}
	public void setValorMayores(int valorMayores) {
		this.valorMayores = valorMayores;
	}
	
	
	
}
