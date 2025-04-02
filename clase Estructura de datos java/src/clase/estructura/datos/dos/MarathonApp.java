package clase.estructura.datos.dos;
import java.util.*;

public class MarathonApp {

    private static final String[] NOMBRES = {"Juan", "María", "Pedro", "Ana", "Luis"};
    private static final String[] APELLIDOS = {"Pérez", "Gómez", "Rodríguez", "López", "Martínez"};
    private static final String[] GRUPOS_SANGUINEOS = {"A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-"};
    private static final String[] CATEGORIAS = {"chico", "medio", "avanzado"};
    public static void main(String[] args) {
        MarathonApp app = new MarathonApp();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Inscription inscription = new Inscription();
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    executeOption1(scanner, inscription);
                    break;
                case 2:
                    executeOption2(inscription);
                    break;
                case 3:
                    executeOption3(inscription);
                    break;
                case 4:
                    executeOption4(scanner, inscription);
                    break;
                case 5:
                    executeOption5(inscription);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Inscribir participante");
        System.out.println("2. Inscribir participantes al azar");
        System.out.println("3. Mostrar inscritos");
        System.out.println("4. Remover participante");
        System.out.println("5. Mostrar precios de los circuitos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void printCategoryMenu() {
        System.out.println("\n=== CATEGORIAS ===");
        System.out.println("1. Circuito chico");
        System.out.println("2. Circuito medio");
        System.out.println("3. Circuito avanzado");
        System.out.print("Seleccione una opción: ");
    }

    private int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private int precioInscripcion(int edad, String tipo_recorrido) {
        if(tipo_recorrido.equals("chico")) {
            if (edad < 18) {
                return 1300;
            }else{
                return 1500;
            }
        }else if(tipo_recorrido.equals("medio")){
            if (edad < 20) {
                return 2000;
            }else{
                return 2300;
            }
        } else if (tipo_recorrido.equals("avanzado")) {
            if (edad < 18) {
                return 0;
            }else{
                return 2800;
            }
        }
        return edad;
    }

    private void setInscription(Inscription inscription, int id, String nombre, String apellido, int edad, String celular, String numero_emergencia, String grupo_sanguineo, int precio, String categoria) {
        Participant participante = new Participant(id, nombre,  apellido,  edad, celular, numero_emergencia, grupo_sanguineo, precio, categoria);
        inscription.addParticipante(participante);
    }

    private void executeOption1(Scanner scanner,  Inscription inscription) {
        boolean exit = false;
        String category = "";

        while (!exit) {
            printCategoryMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    category = "chico";
                    exit = true;
                    break;
                case 2:
                    category = "medio";
                    exit = true;
                    break;
                case 3:
                    category = "avanzado";
                    exit = true;
                    break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }


        System.out.print("Ingrese el numero del participante: ");
        int id = scanner.nextInt();

        System.out.print("Ingrese nombre del participante: ");
        String nombre = scanner.next();

        System.out.print("Ingrese apellido del participante: ");
        String apellido = scanner.next();

        System.out.print("Ingrese edad del participante: ");
        int edad = scanner.nextInt();

        System.out.print("Ingrese celular del participante: ");
        String celular = scanner.next();

        System.out.print("Ingrese numero de emergencia del participante: ");
        String numero_emergencia = scanner.next();

        System.out.print("Ingrese el grupo sanguineo del participante: ");
        String grupo_sanguineo = scanner.next();

        int precio = precioInscripcion(edad, category);
        if(precio==0) {
            System.out.println("El participante no puede inscribirse porque es menor de edad.");
        }else{
           setInscription(inscription, id, nombre, apellido, edad, celular, numero_emergencia, grupo_sanguineo, precio, category);
        }

    }

    private void executeOption2(Inscription inscription) {
        Random random = new Random();

        for (int i = 1; i <= 3; i++) {
            int id = i;
            String nombre = NOMBRES[random.nextInt(NOMBRES.length)];
            String apellido = APELLIDOS[random.nextInt(APELLIDOS.length)];
            int edad = 18 + random.nextInt(52);
            String celular = "555-" + (1000 + random.nextInt(9000));
            String numero_emergencia = "555-" + (1000 + random.nextInt(9000));
            String grupo_sanguineo = GRUPOS_SANGUINEOS[random.nextInt(GRUPOS_SANGUINEOS.length)];
            String categoria = CATEGORIAS[i-1];
            int precio = precioInscripcion(edad,categoria);

            setInscription(inscription, id, nombre, apellido, edad, celular, numero_emergencia, grupo_sanguineo, precio, categoria);
        }
    }

    private void executeOption3(Inscription inscription) {
        inscription.mostrarInscritos();
    }

    private void executeOption4(Scanner scanner,  Inscription inscription) {
        boolean exit = false;
        int id = 0;
        while (!exit) {
            System.out.print("Ingrese el numero del participante: ");
            id = scanner.nextInt();
            exit = true;
        }
        inscription.removeParticipante(id);
    }

    private void executeOption5(Inscription inscription) {
        inscription.getPrices();
    }
}