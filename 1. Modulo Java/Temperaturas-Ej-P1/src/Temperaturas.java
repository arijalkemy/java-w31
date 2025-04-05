import java.util.HashMap;

public class Temperaturas {
    public static void main(String[] args) {
        // Vector de ciudades
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };
        // Matriz de temperaturas (mínima y máxima)
        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int cities = ciudades.length;
        String cityLowerTemp = ciudades[0];
        String cityHigherTemp = ciudades[0];
        int lowerTemp = temperaturas[0][0];
        int higherTemp = temperaturas[0][1];

        for(int i = 0; i < cities; i++){
            if (lowerTemp > temperaturas[i][0]) {
                lowerTemp = temperaturas[i][0];
                cityLowerTemp = ciudades[i];

            }
            else if (higherTemp < temperaturas[i][1]) {
                higherTemp = temperaturas[i][1];
                cityHigherTemp = ciudades[i];
            }
        }

        System.out.println("La menor temperatura la tuvo " + cityLowerTemp + ", con " + lowerTemp + "C");
        System.out.println("La mayor temperatura la tuvo " + cityHigherTemp + ", con " + higherTemp + "C");

    }
}