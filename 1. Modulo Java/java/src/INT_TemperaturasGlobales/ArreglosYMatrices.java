package INT_TemperaturasGlobales;

public class ArreglosYMatrices {
    public static void main(String[] args) {

        //defino y cargo datos en vector y matriz
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

        //defino e inicializo variables de resultado
        int temperaturaMax=-1000000;
        int temperaturaMin=1000000;
        String ciudadMax="";
        String ciudadMin="";

        //recorro el vector primero
        for (int i=0;i < ciudades.length;i++){
            //evaluo la temperatura minima y comparo valor de la matriz con mi variable resultado
            if (temperaturas[i][0] < temperaturaMin){
                temperaturaMin = temperaturas[i][0];
                ciudadMin = ciudades[i];
            }

            //evaluo la temperatura maxima y comparo valor de la matriz con mi variable resultado
            if (temperaturas[i][1] > temperaturaMax){
                temperaturaMax = temperaturas[i][1];
                ciudadMax = ciudades [i];
            }
        }

        //imprimo en pantalla los resultados
        System.out.println("La menor temperatura la tuvo "+ciudadMin+" con "+temperaturaMin+"°");
        System.out.println("La mayor temperatura la tuvo "+ciudadMax+" con "+temperaturaMax+"°");

    }
}
