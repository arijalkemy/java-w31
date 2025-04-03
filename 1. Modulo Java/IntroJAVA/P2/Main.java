package IntroJAVA.P2;

/*
 * Todos los años en la provincia de Misiones, al norte de Argentina se lleva a cabo un evento
 * conocido como “Carrera de la Selva”. El mismo se trata de una competición donde los mejores
 * maratonistas y corredores de Latinoamérica se reúnen para desafiar sus habilidades deportivas.
 * 
 * La competencia cuenta con 3 categorías dependiendo de su dificultad y de ellas se guarda una
 * id, el nombre y una breve descripción:
 *  Circuito chico: 2 km por selva y arroyos.
 *  Circuito medio: 5 km por selva, arroyos y barro.
 *  Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
 * Para poder conocer en qué categoría competirá cada participante se manejarán inscripciones.
 * Cada inscripción debe contar con un número de inscripción, una categoría, un participante y
 * el monto a abonar por el participante.
 * 
 * Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción,
 * proporcionar los siguientes datos: número de participante, dni, nombre, apellido, edad, celular,
 * número de emergencia y grupo sanguíneo.
 * 
 * Para concluir con la inscripción, se debe calcular el monto a abonar por cada participante.
 * Para ello se tienen en cuenta los siguientes valores:
 * - Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
 * - Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
 * - Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18
 * años $2800
 * 
 * A partir de estos datos brindados, los organizadores de la carrera manifestaron que necesitan de
 * una aplicación que sea capaz de:
 * 
 * Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
 * Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que
 * deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene
 * 21 años, el monto a abonar es de $1500).
 * Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
 * Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes
 * datos y número de inscripción.
 * Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde
 * se encontraba.
 * Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo
 * todas las categorías.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Categoria> categorias = new ArrayList<>();
        ArrayList<Participante> participantes = new ArrayList<>();
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
    
        System.out.println("Bienvenido al sistema de gestión de la Carrera de la Selva.");
        System.out.println("===============================================================================");
            
        Scanner scanner = new Scanner(System.in);
            
        while (true) {
            System.out.println("Por favor, introduzca el número correspondiente a la acción que desea realizar:");
            System.out.println("1. Crear categorías.");
            System.out.println("2. Inscribir participante.");
            System.out.println("3. Inscribir participantes al azar.");
            System.out.println("4. Mostrar inscriptos en una categoría.");
            System.out.println("5. Desinscribir participante.");
            System.out.println("6. Calcular monto total recaudado.");
            System.out.println("7. Salir.");
    
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crearCategoria(scanner, categorias);
                    break;
                case 2:
                    inscribirParticipante(categorias, participantes, inscripciones);
                    break;
                case 3:
                    inscribirParticipantesAzar(categorias, participantes, inscripciones);
                    break;
                case 4:
                    mostrarInscriptosCategoria(categorias, inscripciones);
                    break;
                case 5:
                    desinscribirParticipante(participantes, inscripciones);
                    break;
                case 6:
                    calcularMontoTotalRecaudado(inscripciones, categorias);
                    break;
                case 7:
                    System.out.println("Gracias por utilizar el sistema de gestión de la Carrera de la Selva.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }

    private static void crearCategoria(Scanner scanner, List<Categoria> categorias) {
        System.out.println("Por favor, introduzca el nombre de la categoría:");
        
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre de la categoría no puede estar vacío. Inténtalo de nuevo.");
            return;
        }
        
        System.out.println("Por favor, introduzca una breve descripción para la categoría:");
        String descripcion = scanner.nextLine().trim();
        if (descripcion.isEmpty()) {
            System.out.println("La descripción no puede estar vacía. Se utilizará una descripción por defecto.");
            descripcion = "Descripción no proporcionada.";
        }

        Categoria categoria = new Categoria(nombre, descripcion);
        categorias.add(categoria);
        
        System.out.println("Categoría creada con éxito: " + categoria.getNombre() + " - " + categoria.getDescripcion());
        System.out.println("===============================================================================");
    }

    private static Participante crearParticipante(ArrayList<Participante> participantes) {
        Scanner scannerInts = new Scanner(System.in);
        Scanner scannerStrings = new Scanner(System.in);
        System.out.println("Por favor, introduzca el DNI del participante:");
        int dni = scannerInts.nextInt();
        System.out.println("Por favor, introduzca el nombre del participante:");
        String nombre = scannerStrings.nextLine();
        System.out.println("Por favor, introduzca el apellido del participante:");
        String apellido = scannerStrings.nextLine();
        System.out.println("Por favor, introduzca la edad del participante:");
        int edad = scannerInts.nextInt();
        System.out.println("Por favor, introduzca el número de celular del participante:");
        int celular = scannerInts.nextInt();
        System.out.println("Por favor, introduzca el número de emergencia del participante:");
        int númeroEmergencia = scannerInts.nextInt();
        System.out.println("Por favor, introduzca el grupo sanguíneo del participante:");
        String grupoSanguíneo = scannerStrings.nextLine();

        Participante participante = new Participante(dni, nombre, apellido, edad, celular, númeroEmergencia, grupoSanguíneo);
        participantes.add(participante);
        System.out.println("Participante registrado con éxito: " + participante.getNombre() + " " + participante.getApellido());
        System.out.println("===============================================================================");
        scannerInts.close();
        scannerStrings.close();
        return participante;
    }

    private static void inscribirParticipante(ArrayList<Categoria> categorias, ArrayList<Participante> participantes, ArrayList<Inscripcion> inscripciones) {
        Participante participante = crearParticipante(participantes);
        
        System.out.println("Por favor, introduzca el número de la categoría a la que desea inscribir al participante:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getId() + ". " + categoria.getNombre());
        }
        Scanner scanner = new Scanner(System.in);
        int idCategoria = scanner.nextInt();
        Categoria categoria = categorias.get(idCategoria);
        if (categoria == null) {
            System.out.println("La categoría seleccionada no es válida.");
            System.out.println("===============================================================================");
            scanner.close();
            return;
        }
        Inscripcion inscripcion = new Inscripcion(categoria, participante);
        inscripciones.add(inscripcion);
        System.out.println("Participante inscripto con éxito en la categoría: " + categoria.getNombre());
        System.out.println("Monto a abonar: $" + inscripcion.getMonto());
        System.out.println("===============================================================================");
        scanner.close();
    }

    private static void inscribirParticipantesAzar(ArrayList<Categoria> categorias, ArrayList<Participante> participantes, ArrayList<Inscripcion> inscripciones) {
        Random random = new Random();
        int cantidadParticipantes = random.nextInt(10) + 1;
        for (int i = 0; i < cantidadParticipantes; i++) {
            int edad = random.nextInt(100) + 1;
            Participante participante = new Participante(random.nextInt(1000000000), "Participante " + i, "Apellido " + i, edad, random.nextInt(1000000000), random.nextInt(1000000000), "O+");
            int idCategoria = random.nextInt(categorias.size());
            Inscripcion inscripcion = new Inscripcion(categorias.get(idCategoria), participante);
            inscripciones.add(inscripcion);
            participantes.add(participante);
            System.out.println("Participante aleatorio inscripto con éxito en la categoría: " + categorias.get(idCategoria).getNombre());
            System.out.println("Monto a abonar: $" + inscripcion.getMonto());
        }
    }

    private static void mostrarInscriptosCategoria(Categoria categoria, ArrayList<Inscripcion> inscripciones) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == categoria.getId()) {
                System.out.println("Número de inscripción: " + inscripcion.getId());
                System.out.println("Nombre: " + inscripcion.getParticipante().getNombre() + " " + inscripcion.getParticipante().getApellido());
                System.out.println("DNI: " + inscripcion.getParticipante().getDni());
                System.out.println("Edad: " + inscripcion.getParticipante().getEdad());
                System.out.println("Celular: " + inscripcion.getParticipante().getCelular());
                System.out.println("Número de emergencia: " + inscripcion.getParticipante().getNúmeroEmergencia());
                System.out.println("Grupo sanguíneo: " + inscripcion.getParticipante().getGrupoSanguíneo());
                System.out.println("Monto a abonar: $" + inscripcion.getMonto());
                System.out.println("===============================================================================");
            }
        }
    }

    private static void mostrarInscriptosCategoria(ArrayList<Categoria> categorias, ArrayList<Inscripcion> inscripciones) {
        System.out.println("Por favor, introduzca el número de la categoría de la que desea ver los inscriptos:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getId() + ". " + categoria.getNombre());
        }
        Scanner scanner = new Scanner(System.in);
        Categoria categoria = categorias.get(scanner.nextInt());
        if (categoria == null) {
            System.out.println("La categoría seleccionada no es válida.");
            System.out.println("===============================================================================");
            scanner.close();
            return;
        }
        mostrarInscriptosCategoria(categoria, inscripciones);
        scanner.close();
    }

    private static void desinscribirParticipante(ArrayList<Participante> participantes, ArrayList<Inscripcion> inscripciones) {
        System.out.println("Por favor, introduzca el DNI del participante que desea desinscribir:");
        Scanner scanner = new Scanner(System.in);
        int dniParticipante = scanner.nextInt();
        for (Participante participante: participantes) {
            if (participante.getDni() == dniParticipante) {
                for (Inscripcion inscripcion: inscripciones) {
                    if (inscripcion.getParticipante().getDni() == dniParticipante) {
                        inscripciones.remove(inscripcion);
                        System.out.println("Participante desinscripto con éxito.");
                        System.out.println("===============================================================================");
                        scanner.close();
                        return;
                    }
                }
            }
        }
        System.out.println("No se encontró ningún participante con el DNI ingresado.");
        System.out.println("===============================================================================");
        scanner.close();
    }

    private static void calcularMontoTotalRecaudado(ArrayList<Inscripcion> inscripciones, ArrayList<Categoria> categorias) {
        int montoTotal = 0;
        for (Categoria categoria: categorias) {
            int montoCategoria = 0;
            for (Inscripcion inscripcion: inscripciones) {
                if (inscripcion.getCategoria().getId() == categoria.getId()) {
                    montoCategoria += inscripcion.getMonto();
                }
            }
            System.out.println("Monto total recaudado por la categoría " + categoria.getNombre() + ": $" + montoCategoria);
            montoTotal += montoCategoria;
        }
        System.out.println("Monto total recaudado por toda la carrera: $" + montoTotal);
        System.out.println("===============================================================================");
    }
}

