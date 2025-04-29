//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String [] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "São Paulo", "Lima", "Santiago de Chile" , "Lisboa", "Tokio" };

        int[][] temperatures = {
                {-2, 33},   // Londres
                {-3, 32},   // Madrid
                {-8, 27},   // Nueva York
                {4, 37},    // Buenos Aires
                {6, 42},    // Asunción
                {5, 43},    // São Paulo
                {0, 39},    // Lima
                {-7, 26},   // Santiago de Chile
                {-1, 31},   // Lisboa
                {-10, 35}   // Tokio
        };
        int minima = 0; //(guardo los i)
        int maxima = 0;
        for ( int i=0; i<cities.length; i++ ) {
            if (temperatures[i][0] < temperatures[minima][0]) {
                minima = i ;
            }
            if (temperatures[i][1] > temperatures[maxima][1]) {
                maxima = i ;
            }
        }
        System.out.println("La menor temperatura la tuvo "+cities[minima]+", con "+temperatures[minima][0]+" º C. ");
        System.out.println("La mayor temperatura la tuvo "+cities[maxima]+", con "+temperatures[maxima][1]+" º C. ");
    }
    }