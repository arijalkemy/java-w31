import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[10];
        double temperaturas[][] = new double[10][2];

        /* String[] ciudades = {"Londres","Madrid", "Nueva York",
                "Buenos Aires", "Asuncion", "Sao Paulo",
        "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {{-2, 33},{-3, 32},{-10, 27},
                {4, 37},{6, 42},{5, 43},{0, 39},
                {-7, 26},{-1, 31},{-10, 35}};
         */

        Scanner t = new Scanner(System.in);
        Scanner t2 = new Scanner(System.in);

        for(int i=0; i<10; i++){
            System.out.println("Ingrese las ciudades: ");
            ciudades[i] = t.nextLine();

            for(int j=0; j<2; j++){
                if(j == 0){
                    System.out.println("Ingrese la temperatura minima: ");
                    temperaturas[i][j] = t2.nextInt();
                }else{
                    System.out.println("Ingrese la temperatura maxima: ");
                    temperaturas[i][j] = t2.nextInt();
                }
            }
        }

        double tempMin = temperaturas[0][0];
        double tempMax = temperaturas[0][0];
        String ciudadMin = ciudades [0];
        String ciudadMax = ciudades[0];

        for(int i=0; i<10; i++){
            for(int j=0; j<2; j++){
                if(temperaturas[i][j] < tempMin){
                    tempMin = temperaturas[i][j];
                    ciudadMin = ciudades[i];
                }
                else if(temperaturas[i][j] > tempMax){
                    tempMax = temperaturas[i][j];
                    ciudadMax = ciudades[i];
                }
            }
        }

        System.out.println("Temperatura mínima: " + tempMin + "°C en " + ciudadMin);
        System.out.println("Temperatura máxima: " + tempMax + "°C en " + ciudadMax);
    }
}