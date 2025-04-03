package parteuno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();


        System.out.println("\t SaveTheRopa S.A");
        int opt = 0;
        do{
            System.out.println("1- Ingresar ropa");
            System.out.println("2- Consultar guarda ropa por codigo");
            System.out.println("3- Ver guarda ropa");
            System.out.println("0- Salir");
            System.out.print("Elige una opción: ");
            try{
                opt = scanner.nextInt();
            }catch (Exception e){
                System.out.println("\tError al ingresar la opcion");
                continue;
            }

            switch (opt){
                case 1:
                    List<Prenda> prendas = new ArrayList<>();
                    ingresarPrenda(prendas, guardaRopa);
                    break;
                case 2:
                    System.out.print("Ingresa el codigo: ");
                    int codigo = scanner.nextInt();
                    consultarPrendasPorCodigo(guardaRopa, codigo);
                    break;
                case 3:
                    consultarPrendas(guardaRopa);
                    break;
                default:
                    break;
            }

        }while(opt != 0);


        System.out.println("Consulte su gu");
    }

    private static void ingresarPrenda(List<Prenda> prendas, GuardaRopa guardaRopa){
        System.out.print("Ingresa un numero de prendas que desea guardar: ");
        int numeroPrendas = scanner.nextInt();
        for (int i = 0; i < numeroPrendas; i++) {
            System.out.println("Prenda " + (i + 1));
            System.out.print("Marca: ");
            String marca = scanner.next();
            System.out.print("Modelo: ");
            String modelo = scanner.next();
            prendas.add(new PrendaAlmacenada( marca, modelo));
        }
        System.out.println("Codigo de guarda ropa: " + guardaRopa.guardarPrendas(prendas));
    }

    private static void consultarPrendasPorCodigo(GuardaRopa guardaRopa, Integer codigo){
        List<Prenda> prendas = guardaRopa.devolverPrendas(codigo);
        for (Prenda prenda : prendas) {
            System.out.println("Prendas: " + prenda.toString());
        }
    }

    private static void consultarPrendas(GuardaRopa guardaRopa){
        guardaRopa.mostrarPrendas();
    }
}
