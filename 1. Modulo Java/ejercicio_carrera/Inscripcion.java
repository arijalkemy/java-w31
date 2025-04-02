public class Inscripcion {
    public int numeroInscripcion;
    public Categoria categoria;
    public Participante participante;
    public int monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        calcularMonto();
    }

    public void calcularMonto() {
        switch (this.categoria.id) {
            case 1:
                this.monto = participante.esMayorDeEdad() ? 1500 : 1300;
                break;
            case 2:
                this.monto = participante.esMayorDeEdad() ? 2300 : 200;
                break;
            case 3:
                this.monto = 2800;
                break;
        }
    }
}
