package clase.estructura.datos.uno;

public class Main {
    public static void main(String[] args) {

        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[] rawTemperatures = {
                -2, 33, -3, 32, -8, 27, 4, 37, 6, 42,
                5, 43, 0, 39, -7, 26, -1, 31, -10, 35
        };

        int[][] temperatures = new int[2][rawTemperatures.length / 2];

        for (int i = 0; i < rawTemperatures.length; i++) {
            if (i % 2 == 0) {
                temperatures[0][i / 2] = rawTemperatures[i];
            } else {
                temperatures[1][i / 2] = rawTemperatures[i];
            }
        }

        int tempMinima = temperatures[0][0];
        String cityOfTempMin = null;
        for (int i = 0; i < temperatures[0].length; i++) {
            if (temperatures[0][i] < tempMinima  ) {
                tempMinima = temperatures[0][i];
                cityOfTempMin = cities[i];
            }
        }
        System.out.print("temperatura minima: "+tempMinima +" de la ciudad "+cityOfTempMin +"\n");

        int tempMaxima = temperatures[0][1];
        String tempMaximaCiudad = null;
        for (int i = 0; i < temperatures[0].length; i++) {
            if (temperatures[1][i] > tempMaxima  ) {
                tempMaxima = temperatures[1][i];
                tempMaximaCiudad = cities[i];
            }
        }
        System.out.print("temperatura maxima: "+tempMaxima + " de la ciudad "+tempMaximaCiudad);
    }


}