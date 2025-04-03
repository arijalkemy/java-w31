package exercisePractice;
public class MainTemperaturas {
    public static void main(String[] args) {
        String[] ciudades;
        ciudades = new String[] { "Londres", "Madrid", "Nueva York", "Buenos Aires", " Asuncion", "Sao Paulo", "Lima",
                "Santiago de chile",
                "lisboa", "Tokio" };

        int[][] temperature = new int[][] {
                { -2, 33 },
                { -3, 32 },
                { -8, 27 },
                { 4, 37 },
                { 6, 42 },
                { 5, 43 },
                { 0, 39 },
                { -7, 26 },
                { -1, 31 },
                { -10, 35 },
        };

        int MaxTemp = temperature[0][1];
        int minTemp = temperature[0][0];
        int indexCityMinTemp = 0;
        int indexCityMaxTemp = 0;
        for (int m = 0; m < temperature.length; m++) {
            // dar valores a maxtemp y mintemp ubicados en la posición 0
            if(m != 0){
                if( temperature [m][0]<minTemp ){
                    minTemp = temperature [m][0] ;
                    indexCityMinTemp = m;

                }
                if(temperature[m][1] > MaxTemp){
                    MaxTemp = temperature [m][1];
                    indexCityMaxTemp = m;
                } 
            }
        }

        System.out.println("Ciudad con temperatura mínima  " + ciudades[indexCityMinTemp] + " temperatura : " +  minTemp + 
        " ciudad con mayor temperatura " + ciudades [indexCityMaxTemp] +  " temperatura maxima " + MaxTemp);
    }

}
/*
 * guardar min y max temp en variables globales
 * validar posicion temp con la posicion de ciudad y obtener el nombre
 * imprimir
 */