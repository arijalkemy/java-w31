public class temperaturasGlobales {

    public static void main(String[] args) {
	// write your code here

        // Vector de ciudades
        String[] ciudades = {
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

        // Matriz de temperaturas
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

        int mayorTemperatura = Integer.MIN_VALUE;
        int menorTemperatura = Integer.MAX_VALUE;
        String ciudadMayor = "";
        String ciudadMenor = "";


        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                if (temperaturas[i][j] > mayorTemperatura ) {
                    mayorTemperatura = temperaturas[i][j];
                    ciudadMayor = ciudades[i];
                }
                if (temperaturas[i][j] < menorTemperatura) {
                    menorTemperatura = temperaturas[i][j];
                    ciudadMenor = ciudades[i];
                }
            }
        }

        System.out.println("La may temperatura la tuvo " + ciudadMayor + ", con temp de: " + mayorTemperatura);
        System.out.println("La men temperatura la tuvo " + ciudadMenor + ", con temp de: " + menorTemperatura);
    }
}
