public class Main {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int indexTemperaturaMin = 0;
        int indexTemperaturaMax = 0;
        // int temperaturaMin = 10000;
        // int temperaturaMax = -10000;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temperaturas[indexTemperaturaMin][0]) {
                indexTemperaturaMin = i;
                // temperaturaMin = temperaturas[i][0];
            }
            if (temperaturas[i][1] > temperaturas[indexTemperaturaMax][1]) {
                indexTemperaturaMax = i;
                // temperaturaMax = temperaturas[i][1];
            }
        }

        System.out.printf("La menor temperatura la tuvo %s, con %d ºC.%n", ciudades[indexTemperaturaMin], temperaturas[indexTemperaturaMin][0]);
        System.out.printf("La mayor temperatura la tuvo %s, con %d ºC.%n", ciudades[indexTemperaturaMax], temperaturas[indexTemperaturaMax][1]);
    }
}