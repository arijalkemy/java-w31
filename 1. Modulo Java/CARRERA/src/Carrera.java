import java.util.*;

class Categoria {
    int id;
    String nombre;
    String descripcion;
    double precioMenor, precioMayor;

    Categoria(int id, String nombre, String descripcion, double precioMenor, double precioMayor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioMenor = precioMenor;
        this.precioMayor = precioMayor;
    }

    double calcularMonto(int edad) {
        if (this.nombre.equals("Circuito Avanzado") && edad < 18) {
            return -1;
        }
        return (edad < 18) ? precioMenor : precioMayor;
    }

    public String getNombre() {
        return nombre;
    }
}

class Participante {
    int numeroParticipante;
    String dni, nombre, apellido, celular, numeroEmergencia, grupoSanguineo;
    int edad;

    Participante(int numeroParticipante, String dni, String nombre, String apellido, int edad,
                 String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public String mostrarDatos() {
        return "N° Participante: " + numeroParticipante + ", Nombre: " + nombre + " " + apellido
                + ", DNI: " + dni + ", Edad: " + edad + ", Celular: " + celular
                + ", Emergencia: " + numeroEmergencia + ", Grupo Sanguíneo: " + grupoSanguineo;
    }
}

class Inscripcion {
    int numeroInscripcion;
    Participante participante;
    Categoria categoria;
    double monto;

    Inscripcion(int numeroInscripcion, Participante participante, Categoria categoria) {
        this.numeroInscripcion = numeroInscripcion;
        this.participante = participante;
        this.categoria = categoria;
        this.monto = categoria.calcularMonto(participante.edad);
    }

    public String mostrarInscripcion() {
        return "Inscripción N°: " + numeroInscripcion + ", " + participante.mostrarDatos() + ", Categoria: " + categoria.getNombre()
                + ", Monto: $" + monto;
    }
}

public class Carrera {
    static List<Inscripcion> inscripciones = new ArrayList<>();
    static List<Categoria> categorias = new ArrayList<>();

    static void crearCategorias() {
        categorias.add(new Categoria(1, "Circuito Chico", "2 km por selva y arroyos", 1300, 1500));
        categorias.add(new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro", 2000, 2300));
        categorias.add(new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 0, 2800));
    }


    static void inscribir(Participante p, Categoria c) {
        double monto = c.calcularMonto(p.edad);
        if (monto > 0) {
            int numeroInscripcion = inscripciones.size() + 1;
            Inscripcion insc = new Inscripcion(numeroInscripcion, p, c);
            inscripciones.add(insc);
            System.out.println(p.nombre + " " + p.apellido + " inscripto en " + c.nombre + " - Monto: $" + monto);
        } else {
            System.out.println(p.nombre + " no puede inscribirse en " + c.nombre + " debido a la edad.");
        }
    }

    static void mostrarInscripcionesPorCategoria(String nombreCategoria) {
        System.out.println("\nInscripciones en " + nombreCategoria + ":");
        for (Inscripcion insc : inscripciones) {
            if (insc.categoria.getNombre().equals(nombreCategoria)) {
                System.out.println(insc.mostrarInscripcion());
            }
        }
    }


    static void desinscribir(int numeroInscripcion) {
        Inscripcion insc = null;
        for (Inscripcion i : inscripciones) {
            if (i.numeroInscripcion == numeroInscripcion) {
                insc = i;
                break;
            }
        }

        if (insc != null) {
            inscripciones.remove(insc);
            System.out.println("\nDesinscripción completada: " + insc.participante.nombre + " " + insc.participante.apellido);
        } else {
            System.out.println("No se encontró una inscripción con el número: " + numeroInscripcion);
        }
    }


    static double calcularTotalPorCategoria(String nombreCategoria) {
        double total = 0;
        for (Inscripcion i : inscripciones) {
            if (i.categoria.getNombre().equals(nombreCategoria)) {
                total += i.monto;
            }
        }
        return total;
    }


    static double calcularTotalCarrera() {
        double total = 0;
        for (Inscripcion i : inscripciones) {
            total += i.monto;
        }
        return total;
    }

    public static void main(String[] args) {

        crearCategorias();

        Participante p1 = new Participante(1, "12345678", "Juan", "Perez", 20, "123456789", "1122334455", "A+");
        Participante p2 = new Participante(2, "87654321", "Maria", "Gonzalez", 16, "987654321", "5544332211", "O-");
        Participante p3 = new Participante(3, "11223344", "Carlos", "Lopez", 25, "555666777", "6677889900", "B+");


        inscribir(p1, categorias.get(0));
        inscribir(p2, categorias.get(1));
        inscribir(p3, categorias.get(2));


        mostrarInscripcionesPorCategoria("Circuito Chico");
        mostrarInscripcionesPorCategoria("Circuito Medio");
        mostrarInscripcionesPorCategoria("Circuito Avanzado");


        System.out.println("\nTotal recaudado Circuito Chico: $" + calcularTotalPorCategoria("Circuito Chico"));
        System.out.println("Total recaudado Circuito Medio: $" + calcularTotalPorCategoria("Circuito Medio"));
        System.out.println("Total recaudado Circuito Avanzado: $" + calcularTotalPorCategoria("Circuito Avanzado"));


        desinscribir(2);


        System.out.println("\nTotal recaudado toda la carrera: $" + calcularTotalCarrera());
    }
}
