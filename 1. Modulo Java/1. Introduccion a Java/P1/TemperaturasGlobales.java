
public class TemperaturasGlobales {

    public static void main(String[] args) {
        String[] ciudades = {
            "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
            "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };

        // Matriz de temperaturas (cada fila tiene: [minima, maxima])
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

        int tempMinimaGlobal = Integer.MAX_VALUE; // Comienza con el valor más alto posible
        int tempMaximaGlobal = Integer.MIN_VALUE; // Comienza con el valor más bajo posible
        String ciudadMinima = "";
        String ciudadMaxima = "";

        // Recorremos la matriz de temperaturas para encontrar las temperaturas mínima y máxima
        for (int i = 0; i < temperaturas.length; i++) {
            int tempMinima = temperaturas[i][0];
            int tempMaxima = temperaturas[i][1];

            // Verificamos si la temperatura mínima actual es la más baja
            if (tempMinima < tempMinimaGlobal) {
                tempMinimaGlobal = tempMinima;
                ciudadMinima = ciudades[i];
            }

            // Verificamos si la temperatura máxima actual es la más alta
            if (tempMaxima > tempMaximaGlobal) {
                tempMaximaGlobal = tempMaxima;
                ciudadMaxima = ciudades[i];
            }
        }

        System.out.println("La menor temperatura fue en " + ciudadMinima + " con " + tempMinimaGlobal + "º C.");
        System.out.println("La mayor temperatura fue en " + ciudadMaxima + " con " + tempMaximaGlobal + "º C.");
    }
}
