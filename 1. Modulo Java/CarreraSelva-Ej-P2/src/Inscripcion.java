public class Inscripcion {
    private int numero;
    private Categoria cat;
    private Participante participante;
    double monto;


    public Inscripcion(int numero, Categoria cat, Participante participante) {
        if (cat.getTipo() == "Avanzado" && participante.getEdad() < 18) {
            throw new IllegalArgumentException("Los menores de 18 años no pueden inscribirse en la categoría Avanzado.");
        }
        this.numero = numero;
        this.cat = cat;
        this.participante = participante;
    }

    public Categoria getCat(){
        return cat;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double calcularMonto() {
        switch (cat.getTipo()) {
            case "Chico":
                if (participante.getEdad() < 18) {
                    monto = 1300;
                } else {
                    monto = 1500;
                }
                break;

            case "Medio":
                if (participante.getEdad() < 18) {
                    monto = 2000;
                } else {
                    monto = 2300;
                }
                break;

            case "Avanzado":
                monto = 2800;
                break;
            default:
                throw new IllegalArgumentException("Categoría no válida: " + cat.getTipo());
        }
        return monto;
    }

    public int getNumero() {
        return numero;
    }
}
