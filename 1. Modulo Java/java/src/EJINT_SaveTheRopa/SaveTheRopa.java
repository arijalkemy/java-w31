package EJINT_SaveTheRopa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveTheRopa {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Scanner scanner = new Scanner(System.in);

        //guardar prendas
        //Prenda prenda1 = new Prenda("Adidas", "Zapatillas");
        //Prenda prenda2 = new Prenda("Nike", "Campera");

        //int id1 = guardaRopa.guardarRopa(prenda1);
        //int id2 = guardaRopa.guardarRopa(prenda2);

        //permitir cargar prendas por teclado
        while (true){
            System.out.println("Desea agregar una prenda? (S/N)");
            String input = scanner.nextLine();
            if (input.equals("N")){
                break;
            } else if (input.equals("S")){
                System.out.print("Ingrese la marca de la prenda: ");
                String marca = scanner.nextLine();
                System.out.print("Ingrese el modelo de la prenda: ");
                String modelo = scanner.nextLine();

                Prenda prenda = new Prenda(marca, modelo);
                int idPrenda = guardaRopa.guardarRopa(prenda);
                System.out.println("Prenda guardada con ID: " + idPrenda);
                } else {
                System.out.println("Opción no valida. Por favor, introduzca S o N.");
                }
            }

        guardaRopa.mostrarPrendas();
        //consultar por id
        System.out.println("Ingrese el ID para consultar por su prenda: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());

        List<Prenda> prendas = guardaRopa.devolverPrendas(idConsulta);
        if (!prendas.isEmpty()) {
            System.out.println("Prendas recuperadas para el ID " + idConsulta + ": " + prendas);
        } else {
            System.out.println("No se encontraron prendas para el ID " + idConsulta);
        }

        scanner.close();

    }
}
