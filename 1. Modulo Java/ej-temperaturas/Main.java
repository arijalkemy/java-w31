public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago", "Lisboa", "Tokio"};
        int [][] temperaturas = {{-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };

        int indiceMinimaTemperatura = 0;
        int indiceMaximaTemperatura = 0;

        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temperaturas[indiceMinimaTemperatura][0]) {
                indiceMinimaTemperatura = i;
            }
            if (temperaturas[i][1] > temperaturas[indiceMaximaTemperatura][1]) {
                indiceMaximaTemperatura = i;
            }
        }

        System.out.println("La temperatura minima se registro en " + ciudades[indiceMinimaTemperatura] +
                " y fue de " + temperaturas[indiceMinimaTemperatura][0] + " y la maxima registrada fue en " +
                ciudades[indiceMaximaTemperatura] + " y fue de " + temperaturas[indiceMaximaTemperatura][1]);
    }
}