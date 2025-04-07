import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner temp_minima = new Scanner(System.in);
        Scanner temp_maxima = new Scanner(System.in);

        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = new int[10][10];


        // String ciudades[] = {"Londres", "Madrid"};
        int temperaturaMinima = Integer.MAX_VALUE;
        int temperaturaMaxima = Integer.MIN_VALUE;
        String ciudadMinima = "";
        String ciudadMaxima = "";

        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ingrese la temperatura minima de la ciudad: " + ciudades[i]);
            int minima_actual = temp_minima.nextInt();
            System.out.println("Ingrese la temperatura maxima de la ciudad: " + ciudades[i]);
            int maxima_actual = temp_maxima.nextInt();

            temperaturas[i][0] = minima_actual;
            temperaturas[i][1] = maxima_actual;

            if (temperaturaMinima > temperaturas[i][0]) {
                temperaturaMinima = temperaturas[i][0];
                ciudadMinima = ciudades[i];
            }
            if (temperaturaMaxima < temperaturas[i][1]) {
                temperaturaMaxima = temperaturas[i][1];
                ciudadMaxima = ciudades[i];
            }
        }
        for (int j = 0; j < temperaturas.length; j++) {
            System.out.println(temperaturas[j][0]);
        }
        System.out.println("La temperatura minima fue: " + temperaturaMinima + "° en la ciudad de " + ciudadMinima + " y la temperatura maxima fue: " + temperaturaMaxima + "° en la ciudad de " + ciudadMaxima);
        temp_maxima.close();
        temp_minima.close();
    }
}
