public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int minTemp = temperatures[0][0];
        int maxTemp = temperatures[0][1];
        String cityMinTemp = cities[0];
        String cityMaxTemp = cities[0];

        for (int i = 0; i < cities.length -1; i++) {
            if (temperatures[i+1][0] < minTemp) {
                minTemp = temperatures[i+1][0];
                cityMinTemp = cities[i+1];
            }

            if (temperatures[i+1][1] > maxTemp) {
                maxTemp = temperatures[i+1][1];
                cityMaxTemp = cities[i+1];
            }
        }

        System.out.println("La menor temperatura la tuvo "+cityMinTemp+", con "+minTemp+"°C");
        System.out.println("La mayor temperatura la tuvo "+cityMaxTemp+", con "+maxTemp+"°C");
    }
}
