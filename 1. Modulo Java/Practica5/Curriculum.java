package Practica5;

public class Curriculum extends Documento implements Imprimible {

    private String telefono;
    private  String[]habilidades;

    public Curriculum(String autor, int cantPaginas, String telefono,  String[] habilidades) {
        super(autor, cantPaginas);
        this.telefono = telefono;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        toString();
    }

    @Override
    public String toString() {
        return super.toString() + "Curriculum{" +
                "telefono='" + telefono + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public  String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades( String[] habilidades) {
        this.habilidades = habilidades;
    }

    // Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.

        public static void main(String[] args) {

            Curriculum curriculum = new Curriculum("Juan", 12,"21223",  new String[]{"Java", "Python", "JavaScript"});

            Imprimible.imprimirDocumento(curriculum);

        }
}
