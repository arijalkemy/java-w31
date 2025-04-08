package temperaturasGlobales;

public class TemperaturasGlobales {
    public static void main(String[] args) {
        String[] ciudades = new String[] {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = new int [][] {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int tempMin = 0;
        String ciudadMin = "";
        int tempMax = 0;
        String ciudadMax = "";

        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                if (temperaturas[i][j] < tempMin) {
                    tempMin = temperaturas[i][j];
                    ciudadMin = ciudades[i];
                } else {
                    tempMax = temperaturas[i][j];
                    ciudadMax = ciudades[i];
                }
            }
        }
        System.out.println(ciudadMin);
        System.out.println(tempMin);
        System.out.println(ciudadMax);
        System.out.println(tempMax);

    }
}
