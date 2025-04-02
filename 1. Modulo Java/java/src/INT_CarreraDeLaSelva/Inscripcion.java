package INT_CarreraDeLaSelva;

public class Inscripcion {
    Categoria categoria;
    Participante participante;
    double monto;

    // Constructor
    public Inscripcion(Categoria categoria, Participante participante) {
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto(); // Calcular el monto al crear la inscripción
    }

    private double calcularMonto() {
        if (categoria.getNombre().equals("Circuito chico")) {
            return (participante.edad < 18) ? 1300 : 1500;
        } else if (categoria.getNombre().equals("Circuito medio")) {
            return (participante.edad < 18) ? 2000 : 2300;
        } else if (categoria.getNombre().equals("Circuito avanzado")) {
            return (participante.edad < 18) ? 0 : 2800; // No se permite a menores de 18
        }
        return 0; // En caso de no coincidir con ninguna categoría
    }

    public String getInformacion() {
        return "Participante: " + participante.nombre + " " + participante.apellido +
                ", Categoria: " + categoria.getNombre() +
                ", Monto: $" + monto;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getMonto() {
        return monto;
    }
}
