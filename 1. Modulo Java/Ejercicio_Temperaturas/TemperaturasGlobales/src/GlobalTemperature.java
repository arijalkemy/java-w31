public class GlobalTemperature {

    public static double[] findCityIndicesWithExtremeTemperatures(double[][] temperatures){
        if (temperatures.length == 0) {
            return new double[]{-1, -1};
        }
        int minIndex = 0, maxIndex = 0;
        double minTemp = temperatures[0][0];
        double maxTemp = temperatures[0][1];
        for(int i = 0; i < temperatures.length; i++){
            if(temperatures[i][0] < minTemp){
                minTemp = temperatures[i][0];
                minIndex = i;
            }
            if(temperatures[i][1] > maxTemp){
                maxTemp = temperatures[i][1];
                maxIndex = i;
            }
        }
        return new double[]{minIndex, maxIndex, minTemp, maxTemp};
    }

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
        double[][] temperatures = {
            {-2, 33},  // Londres
            {-3, 32},  // Madrid
            {-8, 27},  // Nueva York
            {4, 37},   // Buenos Aires
            {6, 42},   // Asunción
            {5, 43},   // São Paulo
            {0, 39},   // Lima
            {-7, 26},  // Santiago de Chile
            {-1, 31},  // Lisboa
            {-10, 35}  // Tokio
        };
        double[] result = findCityIndicesWithExtremeTemperatures(temperatures);
        int minIndex = (int)result[0];
        int maxIndex = (int)result[1];
        double minTemp = result[2];
        double maxTemp = result[3];
        
        System.out.printf("La menor temperatura la tuvo %s, con %.1f ºC.\n", cities[minIndex], minTemp);
        System.out.printf("La mayor temperatura la tuvo %s, con %.1f ºC.\n", cities[maxIndex], maxTemp);
    }
}