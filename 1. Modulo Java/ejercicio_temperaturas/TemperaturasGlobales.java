public class TemperaturasGlobales {
    public String[] ciudades = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
            "Santiago de Chile", "Lisboa", "Tokio" };
    public int[][] temperaturas = {
            { -2, 33 },
            { -3, 32 },
            { -8, 27 },
            { 4, 37 },
            { 6, 42 },
            { 5, 43 },
            { 0, 39 },
            { -7, 26 },
            { -1, 31 },
            { -10, 35 }
    };

    int mayor = Integer.MIN_VALUE;
    int menor = Integer.MAX_VALUE;
    int indiceMayor;
    int indiceMenor;

    public int CiudadMasFria() {
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < menor) {
                menor = temperaturas[i][0];
                indiceMenor = i;
            }
        }
        return indiceMenor;
    }

    public int CiudadMasCalida() {
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][1] > mayor) {
                mayor = temperaturas[i][1];
                indiceMayor = i;
            }
        }
        return indiceMayor;
    }
}