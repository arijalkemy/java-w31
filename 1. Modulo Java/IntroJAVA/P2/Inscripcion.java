package IntroJAVA.P2;

public class Inscripcion {
    public static int contadorInscripciones = 0;

    private int id;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.id = contadorInscripciones++;
        this.categoria = categoria;
        this.participante = participante;
        if (calcularMonto() != -1) {
            this.monto = calcularMonto();
        } else {
            throw new IllegalArgumentException("La categoría no es válida o el participante no cumple con los requisitos de edad.");
        }
    }

    /*
     * Calcula el monto a abonar por la inscripción del participante.
     * 
     * Return:
     * El monto a abonar por la inscripción, o -1 si la categoría no es válida
     * o el participante no cumple con los requisitos de edad.
     */
    private int calcularMonto() {
        if (categoria.getNombre().equals("Circuito chico")) {
            if (participante.getEdad() < 18) {
                return 1300;
            } else {
                return 1500;
            }
        } else if (categoria.getNombre().equals("Circuito medio")) {
            if (participante.getEdad() < 18) {
                return 2000;
            } else {
                return 2300;
            }
        } else if (categoria.getNombre().equals("Circuito avanzado")) {
            if (participante.getEdad() < 18) {
                return -1;
            } else {
                return 2800;
            }
        } else {
            return -1;
        }
    }

    public int getId() {
        return this.id;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    public Participante getParticipante() {
        return this.participante;
    }
    public int getMonto() {
        return this.monto;
    }
}
