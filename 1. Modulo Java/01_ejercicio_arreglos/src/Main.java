public class Main {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
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

        String nombre_ciudad_mayor = ciudades[0];
        String nombre_ciudad_menor = ciudades[0];
        int temperatura_mayor = temperaturas[0][0];
        int temperatura_menor = temperaturas[0][0];

        for(int i = 0; i < ciudades.length; i++ ){
            if(temperatura_menor > temperaturas[i][0]){
                nombre_ciudad_menor = ciudades[i];
                temperatura_menor = temperaturas[i][0];
            }
            if(temperatura_mayor < temperaturas[i][1]){
                nombre_ciudad_mayor = ciudades[i];
                temperatura_mayor = temperaturas[i][1];
            }
        }

        System.out.println(nombre_ciudad_mayor+ ":" + temperatura_mayor);
        System.err.println(nombre_ciudad_menor+ ":"+ temperatura_menor);
    }
}