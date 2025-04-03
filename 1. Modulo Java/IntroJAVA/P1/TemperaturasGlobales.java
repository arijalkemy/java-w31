package IntroJAVA.P1;
/*
 * EJERCICIO:
 * Un portal de noticias tiene registrados datos de las diferentes temperaturas
 * que obtuvieron algunas ciudades del mundo durante el año pasado; a partir de
 * estos registros, pudieron determinar la más baja y la más alta para cada una
 * de las ciudades. Por ejemplo, se determinó que para Londres, la mínima fue de
 * -2º C y la máxima de 33º C. Sin embargo, actualmente necesitan armar una
 * noticia en donde especifiquen cuál es la temperatura máxima que hubo entre
 * todas las ciudades registradas y cuál fue la mínima. Para ello cuentan con un
 * vector con los nombres de cada una de las ciudades y una matriz de dos columnas
 * que especifican su temperatura máxima y mínima, los cuales se especifican
 * a continuación:
 * 
 * (foto)
 * 
 * Sabiendo que cada índice de fila representa a una ciudad. Se necesita conocer
 * la mayor y la menor temperatura entre todas las ciudades; al mismo tiempo se
 * deberá especificar el nombre de la ciudad. Por ejemplo, la menor temperatura
 * la tuvo Tokio, con -10 º C.
 */

public class TemperaturasGlobales {
    private static final int CANT_CIUDADES = 10;
    /*
    * Crea un vector de strings y guarda nombres de ciudades
    * en cada una de sus posiciones.
    * 
    * Return:
    * Vector de strings, con CANT_CIUDADES posiciones.
    */
    private static String[] hardcodearCiudades() {
        String ciudades [] = new String [CANT_CIUDADES];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";
        return ciudades;
    }

    /*
    * Crea una matriz de enteros y guarda temperaturas máximas
    * y mínimas correspondientes a una ciudad diferente en cada fila
    * 
    * Return:
    * Matriz de enteros, donde hay CANT_CIUDADES filas y 2 columnas
    */
    private static int[][] harcodearMatriz() {
        int matriz[][] = new int[CANT_CIUDADES][2]; 
        matriz[0][0] = -2;
        matriz[1][0] = -3;
        matriz[2][0] = -8;
        matriz[3][0] = 4;
        matriz[4][0] = 6;
        matriz[5][0] = 5;
        matriz[6][0] = 0;
        matriz[7][0] = -7;
        matriz[8][0] = -1;
        matriz[9][0] = -10;
        matriz[0][1] = 33;
        matriz[1][1] = 32;
        matriz[2][1] = 27;
        matriz[3][1] = 37;
        matriz[4][1] = 42;
        matriz[5][1] = 43;
        matriz[6][1] = 39;
        matriz[7][1] = 26;
        matriz[8][1] = 31;
        matriz[9][1] = 35;
        return matriz;
    }

    public static void main(String[] args) {
        String ciudades [] = hardcodearCiudades();
        int matrizTemperaturas [][] = harcodearMatriz();

        int indiceMin = -1;
        int indiceMax = -1;
        int tempMax = Integer.MIN_VALUE;
        int tempMin = Integer.MAX_VALUE;
        for (int i=0; i<CANT_CIUDADES; i++) {
            for (int j=0; j<2; j++) {
                int elemento = matrizTemperaturas[i][j];
                if (elemento < tempMin) {
                    tempMin = elemento;
                    indiceMin = i;
                }
                if (elemento > tempMax) {
                    tempMax = elemento;
                    indiceMax = i;
                }
            }
        }

        System.err.println("La temperatura mínima se registró en " + ciudades[indiceMin] + " y fue de " + tempMin + " grados.");
        System.err.println("La temperatura máxima se registró en " + ciudades[indiceMax] + " y fue de " + tempMax + " grados.");
    }
}
