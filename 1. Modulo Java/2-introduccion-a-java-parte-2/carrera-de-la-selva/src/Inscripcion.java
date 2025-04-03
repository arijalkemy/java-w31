public class Inscripcion {
    private int numeroIncripcion;
    private float monto;

    public Inscripcion(int numeroIncripcion, float monto) {
        this.numeroIncripcion = numeroIncripcion;
        this.monto = monto;
    }

    public int getNumeroIncripcion() {
        return numeroIncripcion;
    }

    public float getMonto() {
        return monto;
    }
}
